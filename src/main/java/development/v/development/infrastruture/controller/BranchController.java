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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import development.v.development.application.features.Branch.CreateBranch.CreateBranchUseCase;
import development.v.development.application.features.Branch.CreateBranch.Dtos.CreateBranchRequestDto;
import development.v.development.application.features.Branch.DeleteBranch.DeleteBranchUseCase;
import development.v.development.application.features.Branch.GetAllBranch.GetAllBranchUseCase;
import development.v.development.application.features.Branch.GetAllBranch.Dtos.GetAllBranchQuery;
import development.v.development.application.features.Branch.GetBranchById.GetBranchByIdUseCase;
import development.v.development.application.features.Branch.UpdateBranch.UpdateBranchUseCase;
import development.v.development.application.features.Branch.UpdateBranch.Dtos.UpdateBranchRequest;
import development.v.development.domain.models.Branch;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Branch", description = "Administra las sedes")
@RestController
@RequestMapping("/api/v1/branches")
public class BranchController {

    private final CreateBranchUseCase createUseCase;
    private final GetAllBranchUseCase getAllUseCase;
    private final GetBranchByIdUseCase getByIdUseCase;
    private final UpdateBranchUseCase updateUseCase;
    private final DeleteBranchUseCase deleteUseCase;

    public BranchController(
        CreateBranchUseCase createUseCase,
        GetAllBranchUseCase getAllUseCase,
        GetBranchByIdUseCase getByIdUseCase,
        UpdateBranchUseCase updateUseCase,
        DeleteBranchUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea una nueva sede", description = "Permite crear una nueva sede con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<Branch>> create(
            @Valid @RequestBody CreateBranchRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUseCase.execute(request));
    }

    @Operation(
        summary = "Obtiene una lista paginada de sedes",
        description = "Permite obtener una lista de sedes con paginación y filtros opcionales")
    @GetMapping()
    public ResponseEntity<PaginatedResultDto<List<Branch>>> getAll(
            @ParameterObject
            @Valid
            @ModelAttribute GetAllBranchQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene una sede por su ID", description = "Permite obtener los detalles de una sede específica utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<Branch>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza una sede existente", description = "Permite actualizar los datos de una sede existente utilizando su ID")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<Branch>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateBranchRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina una sede por su ID", description = "Permite eliminar una sede específica utilizando su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<Branch>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
