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

import development.v.development.application.features.DiningArea.CreateDiningArea.CreateDiningAreaUseCase;
import development.v.development.application.features.DiningArea.CreateDiningArea.Dtos.CreateDiningAreaRequestDto;
import development.v.development.application.features.DiningArea.DeleteDiningArea.DeleteDiningAreaUseCase;
import development.v.development.application.features.DiningArea.GetAllDiningArea.GetAllDiningAreaUseCase;
import development.v.development.application.features.DiningArea.GetAllDiningArea.Dtos.GetAllDiningAreaQuery;
import development.v.development.application.features.DiningArea.GetDiningAreaById.GetDiningAreaByIdUseCase;
import development.v.development.application.features.DiningArea.UpdateDiningArea.UpdateDiningAreaUseCase;
import development.v.development.application.features.DiningArea.UpdateDiningArea.Dtos.UpdateDiningAreaRequest;
import development.v.development.domain.models.DiningArea;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "DiningArea", description = "Administra las areas de mesas")
@RestController
@RequestMapping("/api/v1/dining-areas")
public class DiningAreaController {

    private final CreateDiningAreaUseCase createUseCase;
    private final GetAllDiningAreaUseCase getAllUseCase;
    private final GetDiningAreaByIdUseCase getByIdUseCase;
    private final UpdateDiningAreaUseCase updateUseCase;
    private final DeleteDiningAreaUseCase deleteUseCase;

    public DiningAreaController(
        CreateDiningAreaUseCase createUseCase,
        GetAllDiningAreaUseCase getAllUseCase,
        GetDiningAreaByIdUseCase getByIdUseCase,
        UpdateDiningAreaUseCase updateUseCase,
        DeleteDiningAreaUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea una nueva area de mesa", description = "Permite crear una nueva area de mesa con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<DiningArea>> create(
            @Valid @RequestBody CreateDiningAreaRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de areas de mesa", description = "Permite obtener una lista de areas de mesa con paginacion y filtros opcionales")
    @GetMapping()
    public ResponseEntity<PaginatedResultDto<List<DiningArea>>> getAll(
            @ParameterObject @Valid @ModelAttribute GetAllDiningAreaQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene un area de mesa por su ID", description = "Permite obtener los detalles de un area de mesa especifica utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<DiningArea>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza un area de mesa existente", description = "Permite actualizar los datos de un area de mesa existente utilizando su ID")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<DiningArea>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateDiningAreaRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina un area de mesa por su ID", description = "Permite eliminar un area de mesa especifica utilizando su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<DiningArea>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
