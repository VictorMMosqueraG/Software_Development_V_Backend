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

import development.v.development.application.features.Supply.CreateSupply.CreateSupplyUseCase;
import development.v.development.application.features.Supply.CreateSupply.Dtos.CreateSupplyRequestDto;
import development.v.development.application.features.Supply.DeleteSupply.DeleteSupplyUseCase;
import development.v.development.application.features.Supply.GetAllSupply.GetAllSupplyUseCase;
import development.v.development.application.features.Supply.GetAllSupply.Dtos.GetAllSupplyQuery;
import development.v.development.application.features.Supply.GetSupplyById.GetSupplyByIdUseCase;
import development.v.development.application.features.Supply.UpdateSupply.UpdateSupplyUseCase;
import development.v.development.application.features.Supply.UpdateSupply.Dtos.UpdateSupplyRequest;
import development.v.development.domain.models.Supply;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Supply", description = "Administra los insumos")
@RestController
@RequestMapping("/api/v1/supplies")
public class SupplyController {

    private final CreateSupplyUseCase createUseCase;
    private final GetAllSupplyUseCase getAllUseCase;
    private final GetSupplyByIdUseCase getByIdUseCase;
    private final UpdateSupplyUseCase updateUseCase;
    private final DeleteSupplyUseCase deleteUseCase;

    public SupplyController(
        CreateSupplyUseCase createUseCase,
        GetAllSupplyUseCase getAllUseCase,
        GetSupplyByIdUseCase getByIdUseCase,
        UpdateSupplyUseCase updateUseCase,
        DeleteSupplyUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea un nuevo insumo", description = "Permite crear un nuevo insumo con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<Supply>> create(
            @Valid @RequestBody CreateSupplyRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de insumos", description = "Permite obtener una lista de insumos con paginacion y filtros opcionales")
    @GetMapping()
    public ResponseEntity<PaginatedResultDto<List<Supply>>> getAll(
            @ParameterObject
            @Valid
            @ModelAttribute GetAllSupplyQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene un insumo por su ID", description = "Permite obtener los detalles de un insumo especifico utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<Supply>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza un insumo existente", description = "Permite actualizar los datos de un insumo existente utilizando su ID")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<Supply>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateSupplyRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina un insumo por su ID", description = "Permite eliminar un insumo especifico utilizando su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<Supply>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
