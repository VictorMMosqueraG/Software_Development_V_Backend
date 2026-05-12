package development.v.development.infrastruture.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import development.v.development.application.features.ExpenseHeader.CreateExpenseHeader.CreateExpenseHeaderUseCase;
import development.v.development.application.features.ExpenseHeader.CreateExpenseHeader.Dtos.CreateExpenseHeaderRequestDto;
import development.v.development.application.features.ExpenseHeader.DeleteExpenseHeader.DeleteExpenseHeaderUseCase;
import development.v.development.application.features.ExpenseHeader.GetAllExpenseHeader.GetAllExpenseHeaderUseCase;
import development.v.development.application.features.ExpenseHeader.GetAllExpenseHeader.Dtos.GetAllExpenseHeaderQuery;
import development.v.development.application.features.ExpenseHeader.GetExpenseHeaderById.GetExpenseHeaderByIdUseCase;
import development.v.development.application.features.ExpenseHeader.UpdateExpenseHeader.UpdateExpenseHeaderUseCase;
import development.v.development.application.features.ExpenseHeader.UpdateExpenseHeader.Dtos.UpdateExpenseHeaderRequest;
import development.v.development.domain.models.ExpenseHeader;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "ExpenseHeader", description = "Administra los encabezados de egresos")
@RestController
@RequestMapping("/api/v1/expense-headers")
public class ExpenseHeaderController {

    private final CreateExpenseHeaderUseCase createUseCase;
    private final GetAllExpenseHeaderUseCase getAllUseCase;
    private final GetExpenseHeaderByIdUseCase getByIdUseCase;
    private final UpdateExpenseHeaderUseCase updateUseCase;
    private final DeleteExpenseHeaderUseCase deleteUseCase;

    public ExpenseHeaderController(
        CreateExpenseHeaderUseCase createUseCase,
        GetAllExpenseHeaderUseCase getAllUseCase,
        GetExpenseHeaderByIdUseCase getByIdUseCase,
        UpdateExpenseHeaderUseCase updateUseCase,
        DeleteExpenseHeaderUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea un nuevo encabezado de egreso")
    @PostMapping
    public ResponseEntity<DataResultDto<ExpenseHeader>> create(
            @Valid @RequestBody CreateExpenseHeaderRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de encabezados de egresos")
    @GetMapping
    public ResponseEntity<PaginatedResultDto<List<ExpenseHeader>>> getAll(
            @ParameterObject @Valid @ModelAttribute GetAllExpenseHeaderQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene un encabezado de egreso por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<ExpenseHeader>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza un encabezado de egreso existente")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<ExpenseHeader>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateExpenseHeaderRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina un encabezado de egreso por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<ExpenseHeader>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
