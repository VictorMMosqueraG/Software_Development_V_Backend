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

import development.v.development.application.features.DiningTable.CreateDiningTable.CreateDiningTableUseCase;
import development.v.development.application.features.DiningTable.CreateDiningTable.Dtos.CreateDiningTableRequestDto;
import development.v.development.application.features.DiningTable.DeleteDiningTable.DeleteDiningTableUseCase;
import development.v.development.application.features.DiningTable.GetAllDiningTable.GetAllDiningTableUseCase;
import development.v.development.application.features.DiningTable.GetAllDiningTable.Dtos.GetAllDiningTableQuery;
import development.v.development.application.features.DiningTable.GetDiningTableById.GetDiningTableByIdUseCase;
import development.v.development.application.features.DiningTable.UpdateDiningTable.UpdateDiningTableUseCase;
import development.v.development.application.features.DiningTable.UpdateDiningTable.Dtos.UpdateDiningTableRequest;
import development.v.development.domain.models.DiningTable;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "DiningTable", description = "Administra las mesas")
@RestController
@RequestMapping("/api/v1/dining-tables")
public class DiningTableController {

    private final CreateDiningTableUseCase createUseCase;
    private final GetAllDiningTableUseCase getAllUseCase;
    private final GetDiningTableByIdUseCase getByIdUseCase;
    private final UpdateDiningTableUseCase updateUseCase;
    private final DeleteDiningTableUseCase deleteUseCase;

    public DiningTableController(
        CreateDiningTableUseCase createUseCase,
        GetAllDiningTableUseCase getAllUseCase,
        GetDiningTableByIdUseCase getByIdUseCase,
        UpdateDiningTableUseCase updateUseCase,
        DeleteDiningTableUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea una nueva mesa", description = "Permite crear una nueva mesa con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<DiningTable>> create(
            @Valid @RequestBody CreateDiningTableRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de mesas", description = "Permite obtener una lista de mesas con paginacion y filtros opcionales")
    @GetMapping()
    public ResponseEntity<PaginatedResultDto<List<DiningTable>>> getAll(
            @ParameterObject @Valid @ModelAttribute GetAllDiningTableQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene una mesa por su ID", description = "Permite obtener los detalles de una mesa especifica utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<DiningTable>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza una mesa existente", description = "Permite actualizar los datos de una mesa existente utilizando su ID")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<DiningTable>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateDiningTableRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina una mesa por su ID", description = "Permite eliminar una mesa especifica utilizando su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<DiningTable>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
