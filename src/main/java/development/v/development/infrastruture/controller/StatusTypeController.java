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

import development.v.development.application.features.StatusType.CreateStatusType.CreateStatusTypeUseCase;
import development.v.development.application.features.StatusType.CreateStatusType.Dtos.CreateStatusTypeRequestDto;
import development.v.development.application.features.StatusType.DeleteStatusType.DeleteStatusTypeUseCase;
import development.v.development.application.features.StatusType.GetAllStatusType.GetAllStatusTypeUseCase;
import development.v.development.application.features.StatusType.GetAllStatusType.Dtos.GetAllStatusTypeQuery;
import development.v.development.application.features.StatusType.GetStatusTypeById.GetStatusTypeByIdUseCase;
import development.v.development.application.features.StatusType.UpdateStatusType.UpdateStatusTypeUseCase;
import development.v.development.application.features.StatusType.UpdateStatusType.Dtos.UpdateStatusTypeRequest;
import development.v.development.domain.models.StatusType;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "StatusType", description = "Administra los tipos de estado")
@RestController
@RequestMapping("/api/v1/status-types")
public class StatusTypeController {

    private final CreateStatusTypeUseCase createUseCase;
    private final GetAllStatusTypeUseCase getAllUseCase;
    private final GetStatusTypeByIdUseCase getByIdUseCase;
    private final UpdateStatusTypeUseCase updateUseCase;
    private final DeleteStatusTypeUseCase deleteUseCase;

    public StatusTypeController(
        CreateStatusTypeUseCase createUseCase,
        GetAllStatusTypeUseCase getAllUseCase,
        GetStatusTypeByIdUseCase getByIdUseCase,
        UpdateStatusTypeUseCase updateUseCase,
        DeleteStatusTypeUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea un nuevo tipo de estado", description = "Permite crear un nuevo tipo de estado con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<StatusType>> create(
            @Valid @RequestBody CreateStatusTypeRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de tipos de estado", description = "Permite obtener una lista de tipos de estado con paginacion y filtros opcionales")
    @GetMapping()
    public ResponseEntity<PaginatedResultDto<List<StatusType>>> getAll(
            @ParameterObject @Valid @ModelAttribute GetAllStatusTypeQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene un tipo de estado por su ID", description = "Permite obtener los detalles de un tipo de estado especifico utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<StatusType>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza un tipo de estado existente", description = "Permite actualizar los datos de un tipo de estado existente utilizando su ID")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<StatusType>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateStatusTypeRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina un tipo de estado por su ID", description = "Permite eliminar un tipo de estado especifico utilizando su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<StatusType>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
