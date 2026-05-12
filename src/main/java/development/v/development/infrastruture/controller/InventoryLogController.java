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

import development.v.development.application.features.InventoryLog.CreateInventoryLog.CreateInventoryLogUseCase;
import development.v.development.application.features.InventoryLog.CreateInventoryLog.Dtos.CreateInventoryLogRequestDto;
import development.v.development.application.features.InventoryLog.DeleteInventoryLog.DeleteInventoryLogUseCase;
import development.v.development.application.features.InventoryLog.GetAllInventoryLog.GetAllInventoryLogUseCase;
import development.v.development.application.features.InventoryLog.GetAllInventoryLog.Dtos.GetAllInventoryLogQuery;
import development.v.development.application.features.InventoryLog.GetInventoryLogById.GetInventoryLogByIdUseCase;
import development.v.development.application.features.InventoryLog.UpdateInventoryLog.UpdateInventoryLogUseCase;
import development.v.development.application.features.InventoryLog.UpdateInventoryLog.Dtos.UpdateInventoryLogRequest;
import development.v.development.domain.models.InventoryLog;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "InventoryLog", description = "Administra los registros de inventario")
@RestController
@RequestMapping("/api/v1/inventory-logs")
public class InventoryLogController {

    private final CreateInventoryLogUseCase createUseCase;
    private final GetAllInventoryLogUseCase getAllUseCase;
    private final GetInventoryLogByIdUseCase getByIdUseCase;
    private final UpdateInventoryLogUseCase updateUseCase;
    private final DeleteInventoryLogUseCase deleteUseCase;

    public InventoryLogController(
        CreateInventoryLogUseCase createUseCase,
        GetAllInventoryLogUseCase getAllUseCase,
        GetInventoryLogByIdUseCase getByIdUseCase,
        UpdateInventoryLogUseCase updateUseCase,
        DeleteInventoryLogUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea un nuevo registro de inventario", description = "Permite crear un nuevo registro de inventario con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<InventoryLog>> create(
            @Valid @RequestBody CreateInventoryLogRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de registros de inventario", description = "Permite obtener una lista de registros de inventario con paginacion y filtros opcionales")
    @GetMapping()
    public ResponseEntity<PaginatedResultDto<List<InventoryLog>>> getAll(
            @ParameterObject
            @Valid
            @ModelAttribute GetAllInventoryLogQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene un registro de inventario por su ID", description = "Permite obtener los detalles de un registro de inventario especifico utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<InventoryLog>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza un registro de inventario existente", description = "Permite actualizar los datos de un registro de inventario existente utilizando su ID")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<InventoryLog>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateInventoryLogRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina un registro de inventario por su ID", description = "Permite eliminar un registro de inventario especifico utilizando su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<InventoryLog>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
