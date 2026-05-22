package development.v.development.infrastruture.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import development.v.development.application.features.Dish.Common.Dtos.DishResponseDto;
import development.v.development.application.features.Dish.Common.Mappers.DishResponseMapper;
import development.v.development.application.features.Dish.CreateDish.CreateDishUseCase;
import development.v.development.application.features.Dish.CreateDish.Dtos.CreateDishRequestDto;
import development.v.development.application.features.Dish.DeleteDish.DeleteDishUseCase;
import development.v.development.application.features.Dish.GetAllDish.GetAllDishUseCase;
import development.v.development.application.features.Dish.GetAllDish.Dtos.GetAllDishQuery;
import development.v.development.application.features.Dish.GetDishById.GetDishByIdUseCase;
import development.v.development.application.features.Dish.UpdateDish.UpdateDishUseCase;
import development.v.development.application.features.Dish.UpdateDish.Dtos.UpdateDishRequestDto;
import development.v.development.domain.exceptions.BadRequestException;
import development.v.development.domain.models.Dish;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Part;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.Validator;

@Tag(name = "Dish", description = "Administra los platos del restaurante")
@RestController
@RequestMapping("/api/v1/dishes")
public class DishController {

    private final CreateDishUseCase createUseCase;
    private final GetAllDishUseCase getAllUseCase;
    private final GetDishByIdUseCase getByIdUseCase;
    private final UpdateDishUseCase updateUseCase;
    private final DeleteDishUseCase deleteUseCase;
    private final ObjectMapper objectMapper;
    private final Validator validator;

    public DishController(
            CreateDishUseCase createUseCase,
            GetAllDishUseCase getAllUseCase,
            GetDishByIdUseCase getByIdUseCase,
            UpdateDishUseCase updateUseCase,
            DeleteDishUseCase deleteUseCase,
            ObjectMapper objectMapper,
            Validator validator) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
        this.objectMapper = objectMapper;
        this.validator = validator;
    }

    @Operation(summary = "Crea un nuevo plato", description = "Acepta multipart/form-data con part JSON 'dish' o campos planos (plaDescripcion, plaPrecio, estId) y archivo en 'plaImagen' (tambien soporta 'image').")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<DataResultDto<DishResponseDto>> create(
            @RequestPart(value = "dish", required = false) Part dishPart,
            @ModelAttribute CreateDishRequestDto flatRequest,
            @RequestPart(value = "plaImagen", required = false) MultipartFile plaImagen,
            @RequestPart(value = "image", required = false) MultipartFile image) {
        CreateDishRequestDto request = resolveCreateRequest(dishPart, flatRequest);
        validateCreateRequest(request);
        MultipartFile imageFile = resolveImage(plaImagen, image);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(toResponse(createUseCase.execute(request, imageFile)));
    }

    @Operation(summary = "Lista todos los platos paginados", description = "Devuelve la lista de platos con URL de imagen incluida")
    @GetMapping
    public ResponseEntity<PaginatedResultDto<List<DishResponseDto>>> getAll(
            @ParameterObject @ModelAttribute @Valid GetAllDishQuery query) {
        return ResponseEntity.ok(toPaginatedResponse(getAllUseCase.execute(query)));
    }

    @Operation(summary = "Obtiene un plato por ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<DishResponseDto>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(toResponse(getByIdUseCase.execute(id)));
    }

    @Operation(summary = "Actualiza un plato", description = "Acepta multipart/form-data con part JSON 'dish' o campos planos y archivo opcional en 'plaImagen' (tambien soporta 'image'). Si no llega imagen, se conserva la actual.")
    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<DataResultDto<DishResponseDto>> update(
            @PathVariable Integer id,
            @RequestPart(value = "dish", required = false) Part dishPart,
            @ModelAttribute UpdateDishRequestDto flatRequest,
            @RequestPart(value = "plaImagen", required = false) MultipartFile plaImagen,
            @RequestPart(value = "image", required = false) MultipartFile image) {
        UpdateDishRequestDto request = resolveUpdateRequest(dishPart, flatRequest);
        MultipartFile imageFile = resolveImage(plaImagen, image);
        return ResponseEntity.ok(toResponse(updateUseCase.execute(id, request, imageFile)));
    }

    @Operation(summary = "Elimina un plato y su imagen asociada")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<Void>> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }

    private CreateDishRequestDto resolveCreateRequest(Part dishPart, CreateDishRequestDto flatRequest) {
        CreateDishRequestDto dishRequest = parseDishPart(dishPart, CreateDishRequestDto.class);
        if (dishRequest != null && hasCreateData(dishRequest)) {
            return dishRequest;
        }
        return flatRequest;
    }

    private UpdateDishRequestDto resolveUpdateRequest(Part dishPart, UpdateDishRequestDto flatRequest) {
        UpdateDishRequestDto dishRequest = parseDishPart(dishPart, UpdateDishRequestDto.class);
        if (dishRequest != null && hasUpdateData(dishRequest)) {
            return dishRequest;
        }
        return flatRequest;
    }

    private <T> T parseDishPart(Part dishPart, Class<T> type) {
        if (dishPart == null || dishPart.getSize() == 0) {
            return null;
        }

        try {
            String rawJson = new String(dishPart.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            if (rawJson.isBlank()) {
                return null;
            }
            try {
                return objectMapper.readValue(rawJson, type);
            } catch (IOException firstEx) {
                // Algunos clientes envían JSON doblemente serializado: "{\"plaDescripcion\":...}"
                String unwrappedJson = objectMapper.readValue(rawJson, String.class);
                return objectMapper.readValue(unwrappedJson, type);
            }
        } catch (IOException ex) {
            throw new BadRequestException("El part 'dish' no contiene un JSON valido");
        }
    }

    private void validateCreateRequest(CreateDishRequestDto request) {
        Set<ConstraintViolation<CreateDishRequestDto>> violations = validator.validate(request);
        if (!violations.isEmpty()) {
            String errors = violations.stream()
                    .map(v -> v.getPropertyPath() + ": " + v.getMessage())
                    .collect(Collectors.joining(", "));
            throw new BadRequestException(errors);
        }
    }

    private boolean hasCreateData(CreateDishRequestDto request) {
        return request.getPlaDescripcion() != null || request.getPlaPrecio() != null || request.getEstId() != null;
    }

    private boolean hasUpdateData(UpdateDishRequestDto request) {
        return request.getPlaDescripcion() != null || request.getPlaPrecio() != null || request.getEstId() != null;
    }

    private MultipartFile resolveImage(MultipartFile plaImagen, MultipartFile image) {
        if (plaImagen != null && !plaImagen.isEmpty()) {
            return plaImagen;
        }
        if (image != null && !image.isEmpty()) {
            return image;
        }
        return null;
    }

    private DataResultDto<DishResponseDto> toResponse(DataResultDto<Dish> source) {
        DishResponseDto response = DishResponseMapper.toResponse(source.getResults());
        return DataResultDto.success(response, source.getMessage());
    }

    private PaginatedResultDto<List<DishResponseDto>> toPaginatedResponse(PaginatedResultDto<List<Dish>> source) {
        List<DishResponseDto> results = new ArrayList<>();
        if (source.getResults() != null) {
            results = source.getResults().stream()
                    .map(DishResponseMapper::toResponse)
                    .collect(Collectors.toList());
        }

        return PaginatedResultDto.success(
                source.getTotal(),
                source.getPage(),
                source.getPageSize(),
                results,
                source.getMessage());
    }
}

