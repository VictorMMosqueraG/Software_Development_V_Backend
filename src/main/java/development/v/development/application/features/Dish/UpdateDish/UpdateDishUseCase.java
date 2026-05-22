package development.v.development.application.features.Dish.UpdateDish;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import development.v.development.application.features.Dish.UpdateDish.Dtos.UpdateDishRequestDto;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Dish;
import development.v.development.domain.repositories.DishRepository;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.infrastruture.config.FileStorageService;

@Service
public class UpdateDishUseCase {

    private final DishRepository dishRepository;
    private final FileStorageService fileStorageService;

    public UpdateDishUseCase(DishRepository dishRepository, FileStorageService fileStorageService) {
        this.dishRepository = dishRepository;
        this.fileStorageService = fileStorageService;
    }

    public DataResultDto<Dish> execute(Integer id, UpdateDishRequestDto request, MultipartFile image) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        String previousImage = dish.getPlaImagen();
        String newImage = null;

        if (request.getPlaDescripcion() != null) dish.setPlaDescripcion(request.getPlaDescripcion());
        if (request.getPlaPrecio() != null) dish.setPlaPrecio(request.getPlaPrecio());
        if (request.getEstId() != null) dish.setEstId(request.getEstId());

        if (image != null && !image.isEmpty()) {
            newImage = fileStorageService.storeFile(image);
            dish.setPlaImagen(newImage);
        }

        try {
            Dish updated = dishRepository.update(dish);
            if (newImage != null) {
                fileStorageService.deleteFile(previousImage);
            }
            return DataResultDto.success(updated, Message.SUCCESS);
        } catch (RuntimeException ex) {
            if (newImage != null) {
                fileStorageService.deleteFile(newImage);
            }
            throw ex;
        }
    }
}

