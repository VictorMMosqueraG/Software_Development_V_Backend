package development.v.development.infrastruture.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import development.v.development.application.features.Pqrs.CreatePqrs.CreatePqrsUseCase;
import development.v.development.application.features.Pqrs.CreatePqrs.Dtos.CreatePqrsRequestDto;
import development.v.development.application.features.Pqrs.DeletePqrs.DeletePqrsUseCase;
import development.v.development.application.features.Pqrs.GetAllPqrs.GetAllPqrsUseCase;
import development.v.development.application.features.Pqrs.GetAllPqrs.Dtos.GetAllPqrsQuery;
import development.v.development.application.features.Pqrs.GetPqrsById.GetPqrsByIdUseCase;
import development.v.development.application.features.Pqrs.UpdatePqrs.UpdatePqrsUseCase;
import development.v.development.application.features.Pqrs.UpdatePqrs.Dtos.UpdatePqrsRequest;
import development.v.development.domain.models.Pqrs;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Pqrs", description = "Administra las PQRS")
@RestController
@RequestMapping("/api/v1/pqrs")
public class PqrsController {

    private final CreatePqrsUseCase createUseCase;
    private final GetAllPqrsUseCase getAllUseCase;
    private final GetPqrsByIdUseCase getByIdUseCase;
    private final UpdatePqrsUseCase updateUseCase;
    private final DeletePqrsUseCase deleteUseCase;

    public PqrsController(
        CreatePqrsUseCase createUseCase,
        GetAllPqrsUseCase getAllUseCase,
        GetPqrsByIdUseCase getByIdUseCase,
        UpdatePqrsUseCase updateUseCase,
        DeletePqrsUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea un nuevo PQRS")
    @PostMapping
    public ResponseEntity<DataResultDto<Pqrs>> create(
            @Valid @RequestBody CreatePqrsRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de PQRS")
    @GetMapping
    public ResponseEntity<PaginatedResultDto<List<Pqrs>>> getAll(
            @ParameterObject @Valid @ModelAttribute GetAllPqrsQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene un PQRS por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<Pqrs>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza un PQRS existente")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<Pqrs>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdatePqrsRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina un PQRS por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<Pqrs>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
