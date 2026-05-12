package development.v.development.infrastruture.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import development.v.development.application.features.PqrsType.CreatePqrsType.CreatePqrsTypeUseCase;
import development.v.development.application.features.PqrsType.CreatePqrsType.Dtos.CreatePqrsTypeRequestDto;
import development.v.development.application.features.PqrsType.DeletePqrsType.DeletePqrsTypeUseCase;
import development.v.development.application.features.PqrsType.GetAllPqrsType.GetAllPqrsTypeUseCase;
import development.v.development.application.features.PqrsType.GetAllPqrsType.Dtos.GetAllPqrsTypeQuery;
import development.v.development.application.features.PqrsType.GetPqrsTypeById.GetPqrsTypeByIdUseCase;
import development.v.development.application.features.PqrsType.UpdatePqrsType.UpdatePqrsTypeUseCase;
import development.v.development.application.features.PqrsType.UpdatePqrsType.Dtos.UpdatePqrsTypeRequest;
import development.v.development.domain.models.PqrsType;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "PqrsType", description = "Administra los tipos de PQRS")
@RestController
@RequestMapping("/api/v1/pqrs-types")
public class PqrsTypeController {

    private final CreatePqrsTypeUseCase createUseCase;
    private final GetAllPqrsTypeUseCase getAllUseCase;
    private final GetPqrsTypeByIdUseCase getByIdUseCase;
    private final UpdatePqrsTypeUseCase updateUseCase;
    private final DeletePqrsTypeUseCase deleteUseCase;

    public PqrsTypeController(
        CreatePqrsTypeUseCase createUseCase,
        GetAllPqrsTypeUseCase getAllUseCase,
        GetPqrsTypeByIdUseCase getByIdUseCase,
        UpdatePqrsTypeUseCase updateUseCase,
        DeletePqrsTypeUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea un nuevo tipo de PQRS")
    @PostMapping
    public ResponseEntity<DataResultDto<PqrsType>> create(
            @Valid @RequestBody CreatePqrsTypeRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de tipos de PQRS")
    @GetMapping
    public ResponseEntity<PaginatedResultDto<List<PqrsType>>> getAll(
            @ParameterObject @Valid @ModelAttribute GetAllPqrsTypeQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene un tipo de PQRS por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<PqrsType>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza un tipo de PQRS existente")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<PqrsType>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdatePqrsTypeRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina un tipo de PQRS por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<PqrsType>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
