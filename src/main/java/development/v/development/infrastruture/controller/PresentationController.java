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

import development.v.development.application.features.Presentation.CreatePresentation.CreatePresentationUseCase;
import development.v.development.application.features.Presentation.CreatePresentation.Dtos.CreatePresentationRequestDto;
import development.v.development.application.features.Presentation.DeletePresentation.DeletePresentationUseCase;
import development.v.development.application.features.Presentation.GetAllPresentation.GetAllPresentationUseCase;
import development.v.development.application.features.Presentation.GetAllPresentation.Dtos.GetAllPresentationQuery;
import development.v.development.application.features.Presentation.GetPresentationById.GetPresentationByIdUseCase;
import development.v.development.application.features.Presentation.UpdatePresentation.UpdatePresentationUseCase;
import development.v.development.application.features.Presentation.UpdatePresentation.Dtos.UpdatePresentationRequest;
import development.v.development.domain.models.Presentation;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Presentation", description = "Administra las presentaciones")
@RestController
@RequestMapping("/api/v1/presentations")
public class PresentationController {

    private final CreatePresentationUseCase createUseCase;
    private final GetAllPresentationUseCase getAllUseCase;
    private final GetPresentationByIdUseCase getByIdUseCase;
    private final UpdatePresentationUseCase updateUseCase;
    private final DeletePresentationUseCase deleteUseCase;

    public PresentationController(
        CreatePresentationUseCase createUseCase,
        GetAllPresentationUseCase getAllUseCase,
        GetPresentationByIdUseCase getByIdUseCase,
        UpdatePresentationUseCase updateUseCase,
        DeletePresentationUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea una nueva presentacion", description = "Permite crear una nueva presentacion con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<Presentation>> create(
            @Valid @RequestBody CreatePresentationRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de presentaciones", description = "Permite obtener una lista de presentaciones con paginacion y filtros opcionales")
    @GetMapping()
    public ResponseEntity<PaginatedResultDto<List<Presentation>>> getAll(
            @ParameterObject
            @Valid
            @ModelAttribute GetAllPresentationQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene una presentacion por su ID", description = "Permite obtener los detalles de una presentacion especifica utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<Presentation>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza una presentacion existente", description = "Permite actualizar los datos de una presentacion existente utilizando su ID")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<Presentation>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdatePresentationRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina una presentacion por su ID", description = "Permite eliminar una presentacion especifica utilizando su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<Presentation>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
