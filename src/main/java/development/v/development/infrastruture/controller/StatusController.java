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

import development.v.development.application.features.Status.CreateStatus.CreateStatusUseCase;
import development.v.development.application.features.Status.CreateStatus.Dtos.CreateStatusRequestDto;
import development.v.development.application.features.Status.DeleteStatus.DeleteStatusUseCase;
import development.v.development.application.features.Status.GetAllStatus.GetAllStatusUseCase;
import development.v.development.application.features.Status.GetAllStatus.Dtos.GetAllStatusQuery;
import development.v.development.application.features.Status.GetStatusById.GetStatusByIdUseCase;
import development.v.development.application.features.Status.UpdateStatus.UpdateStatusUseCase;
import development.v.development.application.features.Status.UpdateStatus.Dtos.UpdateStatusRequest;
import development.v.development.domain.models.Status;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Status", description = "Administra los estados")
@RestController
@RequestMapping("/api/v1/statuses")
public class StatusController {

    private final CreateStatusUseCase createUseCase;
    private final GetAllStatusUseCase getAllUseCase;
    private final GetStatusByIdUseCase getByIdUseCase;
    private final UpdateStatusUseCase updateUseCase;
    private final DeleteStatusUseCase deleteUseCase;

    public StatusController(
        CreateStatusUseCase createUseCase,
        GetAllStatusUseCase getAllUseCase,
        GetStatusByIdUseCase getByIdUseCase,
        UpdateStatusUseCase updateUseCase,
        DeleteStatusUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea un nuevo estado", description = "Permite crear un nuevo estado con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<Status>> create(
            @Valid @RequestBody CreateStatusRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de estados", description = "Permite obtener una lista de estados con paginacion y filtros opcionales")
    @GetMapping()
    public ResponseEntity<PaginatedResultDto<List<Status>>> getAll(
            @ParameterObject @Valid @ModelAttribute GetAllStatusQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene un estado por su ID", description = "Permite obtener los detalles de un estado especifico utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<Status>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza un estado existente", description = "Permite actualizar los datos de un estado existente utilizando su ID")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<Status>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateStatusRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina un estado por su ID", description = "Permite eliminar un estado especifico utilizando su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<Status>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
