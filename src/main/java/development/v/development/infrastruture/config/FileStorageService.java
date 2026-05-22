package development.v.development.infrastruture.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import development.v.development.domain.exceptions.BadRequestException;

@Service
public class FileStorageService {

    private static final String PUBLIC_UPLOAD_PATH = "/uploads/platos/";
    private static final Set<String> ALLOWED_EXTENSIONS = Set.of(".jpg", ".jpeg", ".png", ".webp");
    private static final Set<String> ALLOWED_CONTENT_TYPES = Set.of("image/jpeg", "image/png", "image/webp");

    private final String uploadDir;
    private final String publicBaseUrl;
    private final long maxFileSizeBytes;

    public FileStorageService(
            @Value("${app.upload.dir:uploads/platos}") String uploadDir,
            @Value("${app.public-base-url:http://localhost:8080}") String publicBaseUrl,
            @Value("${app.upload.max-size-bytes:10485760}") long maxFileSizeBytes) {
        this.uploadDir = uploadDir;
        this.publicBaseUrl = publicBaseUrl;
        this.maxFileSizeBytes = maxFileSizeBytes;
    }

    public String storeFile(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new BadRequestException("El archivo de imagen no puede estar vacío");
        }

        validateFile(file);

        String originalFilename = file.getOriginalFilename();
        String extension = "";
        if (originalFilename != null && originalFilename.contains(".")) {
            extension = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase(Locale.ROOT);
        }

        String filename = UUID.randomUUID() + extension;

        try {
            Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
            Files.createDirectories(uploadPath);
            Path targetLocation = uploadPath.resolve(filename);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new BadRequestException("No se pudo almacenar el archivo: " + ex.getMessage());
        }

        return buildPublicUrl(filename);
    }

    public void deleteFile(String imageUrl) {
        if (imageUrl == null || imageUrl.isBlank()) return;
        try {
            String cleanUrl = imageUrl.split("\\?")[0];
            String filename = cleanUrl.substring(cleanUrl.lastIndexOf("/") + 1);
            Path filePath = Paths.get(uploadDir).toAbsolutePath().normalize().resolve(filename);
            Files.deleteIfExists(filePath);
        } catch (IOException ignored) {
        }
    }

    private void validateFile(MultipartFile file) {
        String extension = extractExtension(file.getOriginalFilename());
        if (!ALLOWED_EXTENSIONS.contains(extension)) {
            throw new BadRequestException("Formato de imagen no permitido. Solo: jpg, jpeg, png, webp");
        }

        String contentType = file.getContentType();
        if (contentType == null || !ALLOWED_CONTENT_TYPES.contains(contentType.toLowerCase(Locale.ROOT))) {
            throw new BadRequestException("Tipo de contenido no permitido para la imagen");
        }

        if (file.getSize() > maxFileSizeBytes) {
            throw new BadRequestException("La imagen supera el tamaño máximo permitido");
        }
    }

    private String extractExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return "";
        }
        return filename.substring(filename.lastIndexOf(".")).toLowerCase(Locale.ROOT);
    }

    private String buildPublicUrl(String filename) {
        String normalizedBaseUrl = publicBaseUrl.endsWith("/")
                ? publicBaseUrl.substring(0, publicBaseUrl.length() - 1)
                : publicBaseUrl;
        return normalizedBaseUrl + PUBLIC_UPLOAD_PATH + filename;
    }
}

