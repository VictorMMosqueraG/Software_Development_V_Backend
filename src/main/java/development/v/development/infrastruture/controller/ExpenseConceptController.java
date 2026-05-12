package development.v.development.infrastruture.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import development.v.development.application.features.ExpenseConcept.CreateExpenseConcept.CreateExpenseConceptUseCase;
import development.v.development.application.features.ExpenseConcept.CreateExpenseConcept.Dtos.CreateExpenseConceptRequestDto;
import development.v.development.application.features.ExpenseConcept.DeleteExpenseConcept.DeleteExpenseConceptUseCase;
import development.v.development.application.features.ExpenseConcept.GetAllExpenseConcept.GetAllExpenseConceptUseCase;
import development.v.development.application.features.ExpenseConcept.GetAllExpenseConcept.Dtos.GetAllExpenseConceptQuery;
import development.v.development.application.features.ExpenseConcept.GetExpenseConceptById.GetExpenseConceptByIdUseCase;
import development.v.development.application.features.ExpenseConcept.UpdateExpenseConcept.UpdateExpenseConceptUseCase;
import development.v.development.application.features.ExpenseConcept.UpdateExpenseConcept.Dtos.UpdateExpenseConceptRequest;
import development.v.development.domain.models.ExpenseConcept;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "ExpenseConcept", description = "Administra los conceptos de egreso")
@RestController
@RequestMapping("/api/v1/expense-concepts")
public class ExpenseConceptController {

    private final CreateExpenseConceptUseCase createUseCase;
    private final GetAllExpenseConceptUseCase getAllUseCase;
    private final GetExpenseConceptByIdUseCase getByIdUseCase;
    private final UpdateExpenseConceptUseCase updateUseCase;
    private final DeleteExpenseConceptUseCase deleteUseCase;

    public ExpenseConceptController(
        CreateExpenseConceptUseCase createUseCase,
        GetAllExpenseConceptUseCase getAllUseCase,
        GetExpenseConceptByIdUseCase getByIdUseCase,
        UpdateExpenseConceptUseCase updateUseCase,
        DeleteExpenseConceptUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea un nuevo concepto de egreso")
    @PostMapping
    public ResponseEntity<DataResultDto<ExpenseConcept>> create(
            @Valid @RequestBody CreateExpenseConceptRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de conceptos de egreso")
    @GetMapping
    public ResponseEntity<PaginatedResultDto<List<ExpenseConcept>>> getAll(
            @ParameterObject @Valid @ModelAttribute GetAllExpenseConceptQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene un concepto de egreso por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<ExpenseConcept>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza un concepto de egreso existente")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<ExpenseConcept>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateExpenseConceptRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina un concepto de egreso por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<ExpenseConcept>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
