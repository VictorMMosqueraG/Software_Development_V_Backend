package development.v.development.infrastruture.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import development.v.development.application.features.DishCategory.CreateDishCategory.CreateDishCategoryUseCase;
import development.v.development.application.features.DishCategory.CreateDishCategory.Dtos.CreateDishCategoryRequestDto;
import development.v.development.application.features.DishCategory.DeleteDishCategory.DeleteDishCategoryUseCase;
import development.v.development.application.features.DishCategory.GetAllDishCategory.GetAllDishCategoryUseCase;
import development.v.development.application.features.DishCategory.GetAllDishCategory.Dtos.GetAllDishCategoryQuery;
import development.v.development.application.features.DishCategory.GetDishCategoryById.GetDishCategoryByIdUseCase;
import development.v.development.application.features.DishCategory.UpdateDishCategory.UpdateDishCategoryUseCase;
import development.v.development.application.features.DishCategory.UpdateDishCategory.Dtos.UpdateDishCategoryRequest;
import development.v.development.domain.models.DishCategory;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "DishCategory", description = "Administra las categorias de platos")
@RestController
@RequestMapping("/api/v1/dish-categories")
public class DishCategoryController {

    private final CreateDishCategoryUseCase createUseCase;
    private final GetAllDishCategoryUseCase getAllUseCase;
    private final GetDishCategoryByIdUseCase getByIdUseCase;
    private final UpdateDishCategoryUseCase updateUseCase;
    private final DeleteDishCategoryUseCase deleteUseCase;

    public DishCategoryController(
        CreateDishCategoryUseCase createUseCase,
        GetAllDishCategoryUseCase getAllUseCase,
        GetDishCategoryByIdUseCase getByIdUseCase,
        UpdateDishCategoryUseCase updateUseCase,
        DeleteDishCategoryUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea una nueva categoria de plato", description = "Permite crear una nueva categoria de plato con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<DishCategory>> create(
            @Valid @RequestBody CreateDishCategoryRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de categorias de plato", description = "Permite obtener una lista de categorias de plato con paginacion y filtros opcionales")
    @GetMapping()
    public ResponseEntity<PaginatedResultDto<List<DishCategory>>> getAll(
            @ParameterObject @Valid @ModelAttribute GetAllDishCategoryQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene una categoria de plato por su ID", description = "Permite obtener los detalles de una categoria de plato especifica utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<DishCategory>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza una categoria de plato existente", description = "Permite actualizar los datos de una categoria de plato existente utilizando su ID")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<DishCategory>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateDishCategoryRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina una categoria de plato por su ID", description = "Permite eliminar una categoria de plato especifica utilizando su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<DishCategory>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
