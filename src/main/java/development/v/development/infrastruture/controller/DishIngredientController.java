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

import development.v.development.application.features.DishIngredient.CreateDishIngredient.CreateDishIngredientUseCase;
import development.v.development.application.features.DishIngredient.CreateDishIngredient.Dtos.CreateDishIngredientRequestDto;
import development.v.development.application.features.DishIngredient.DeleteDishIngredient.DeleteDishIngredientUseCase;
import development.v.development.application.features.DishIngredient.GetAllDishIngredient.GetAllDishIngredientUseCase;
import development.v.development.application.features.DishIngredient.GetAllDishIngredient.Dtos.GetAllDishIngredientQuery;
import development.v.development.application.features.DishIngredient.GetDishIngredientById.GetDishIngredientByIdUseCase;
import development.v.development.application.features.DishIngredient.UpdateDishIngredient.UpdateDishIngredientUseCase;
import development.v.development.application.features.DishIngredient.UpdateDishIngredient.Dtos.UpdateDishIngredientRequest;
import development.v.development.domain.models.DishIngredient;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "DishIngredient", description = "Administra los ingredientes de platos")
@RestController
@RequestMapping("/api/v1/dish-ingredients")
public class DishIngredientController {

    private final CreateDishIngredientUseCase createUseCase;
    private final GetAllDishIngredientUseCase getAllUseCase;
    private final GetDishIngredientByIdUseCase getByIdUseCase;
    private final UpdateDishIngredientUseCase updateUseCase;
    private final DeleteDishIngredientUseCase deleteUseCase;

    public DishIngredientController(
        CreateDishIngredientUseCase createUseCase,
        GetAllDishIngredientUseCase getAllUseCase,
        GetDishIngredientByIdUseCase getByIdUseCase,
        UpdateDishIngredientUseCase updateUseCase,
        DeleteDishIngredientUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea un nuevo ingrediente de plato", description = "Permite crear un nuevo ingrediente de plato con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<DishIngredient>> create(
            @Valid @RequestBody CreateDishIngredientRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de ingredientes de platos", description = "Permite obtener una lista de ingredientes de platos con paginacion y filtros opcionales")
    @GetMapping()
    public ResponseEntity<PaginatedResultDto<List<DishIngredient>>> getAll(
            @ParameterObject
            @Valid
            @ModelAttribute GetAllDishIngredientQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene un ingrediente de plato por su ID", description = "Permite obtener los detalles de un ingrediente de plato especifico utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<DishIngredient>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza un ingrediente de plato existente", description = "Permite actualizar los datos de un ingrediente de plato existente utilizando su ID")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<DishIngredient>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateDishIngredientRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina un ingrediente de plato por su ID", description = "Permite eliminar un ingrediente de plato especifico utilizando su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<DishIngredient>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
