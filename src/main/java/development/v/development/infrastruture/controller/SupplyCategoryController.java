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

import development.v.development.application.features.SupplyCategory.CreateSupplyCategory.CreateSupplyCategoryUseCase;
import development.v.development.application.features.SupplyCategory.CreateSupplyCategory.Dtos.CreateSupplyCategoryRequestDto;
import development.v.development.application.features.SupplyCategory.DeleteSupplyCategory.DeleteSupplyCategoryUseCase;
import development.v.development.application.features.SupplyCategory.GetAllSupplyCategory.GetAllSupplyCategoryUseCase;
import development.v.development.application.features.SupplyCategory.GetAllSupplyCategory.Dtos.GetAllSupplyCategoryQuery;
import development.v.development.application.features.SupplyCategory.GetSupplyCategoryById.GetSupplyCategoryByIdUseCase;
import development.v.development.application.features.SupplyCategory.UpdateSupplyCategory.UpdateSupplyCategoryUseCase;
import development.v.development.application.features.SupplyCategory.UpdateSupplyCategory.Dtos.UpdateSupplyCategoryRequest;
import development.v.development.domain.models.SupplyCategory;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "SupplyCategory", description = "Administra las categorias de insumo")
@RestController
@RequestMapping("/api/v1/supply-categories")
public class SupplyCategoryController {

    private final CreateSupplyCategoryUseCase createUseCase;
    private final GetAllSupplyCategoryUseCase getAllUseCase;
    private final GetSupplyCategoryByIdUseCase getByIdUseCase;
    private final UpdateSupplyCategoryUseCase updateUseCase;
    private final DeleteSupplyCategoryUseCase deleteUseCase;

    public SupplyCategoryController(
        CreateSupplyCategoryUseCase createUseCase,
        GetAllSupplyCategoryUseCase getAllUseCase,
        GetSupplyCategoryByIdUseCase getByIdUseCase,
        UpdateSupplyCategoryUseCase updateUseCase,
        DeleteSupplyCategoryUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea una nueva categoria de insumo", description = "Permite crear una nueva categoria de insumo con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<SupplyCategory>> create(
            @Valid @RequestBody CreateSupplyCategoryRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de categorias de insumo", description = "Permite obtener una lista de categorias de insumo con paginacion y filtros opcionales")
    @GetMapping()
    public ResponseEntity<PaginatedResultDto<List<SupplyCategory>>> getAll(
            @ParameterObject
            @Valid
            @ModelAttribute GetAllSupplyCategoryQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene una categoria de insumo por su ID", description = "Permite obtener los detalles de una categoria de insumo especifica utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<SupplyCategory>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza una categoria de insumo existente", description = "Permite actualizar los datos de una categoria de insumo existente utilizando su ID")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<SupplyCategory>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateSupplyCategoryRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina una categoria de insumo por su ID", description = "Permite eliminar una categoria de insumo especifica utilizando su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<SupplyCategory>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
