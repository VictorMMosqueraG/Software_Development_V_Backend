package development.v.development.infrastruture.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import development.v.development.application.features.CashReceipt.CreateCashReceipt.CreateCashReceiptUseCase;
import development.v.development.application.features.CashReceipt.CreateCashReceipt.Dtos.CreateCashReceiptRequest;
import development.v.development.application.features.CashReceipt.FindAllCashReceipt.GetAllCashReceiptUseCase;
import development.v.development.application.features.CashReceipt.FindAllCashReceipt.Dtos.GetAllCashReceiptQuery;
import development.v.development.application.features.CashReceipt.GetCashReceiptById.GetCashReceiptByIdUseCase;
import development.v.development.application.features.CashReceipt.UpdateCashReceipt.UpdateCashReceiptUseCase;
import development.v.development.application.features.CashReceipt.UpdateCashReceipt.Dtos.UpdateCashReceiptRequest;
import development.v.development.domain.models.CashReceipt;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/cash-receipt")
@Tag(name = "CashReceipt", description = "Administra los recibos de caja")
public class CashReceiptController {

    private final CreateCashReceiptUseCase createUseCase;
    private final GetAllCashReceiptUseCase getAllUseCase;
    private final GetCashReceiptByIdUseCase getByIdUseCase;
    private final UpdateCashReceiptUseCase updateUseCase;

    public CashReceiptController(
            CreateCashReceiptUseCase createUseCase,
            GetAllCashReceiptUseCase getAllUseCase,
            GetCashReceiptByIdUseCase getByIdUseCase,
            UpdateCashReceiptUseCase updateUseCase) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
    }

    @Operation(summary = "Crea un nuevo recibo de caja", description = "Permite crear un nuevo recibo de caja con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<CashReceipt>> create(@Valid @RequestBody CreateCashReceiptRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtener todos los recibos de caja paginados", description = "Retorna una lista paginada de recibos de caja con filtros opcionales")
    @GetMapping
    public ResponseEntity<PaginatedResultDto<List<CashReceipt>>> getAll(
            @ParameterObject @Valid @ModelAttribute GetAllCashReceiptQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtener un recibo de caja por ID", description = "Retorna un recibo de caja específico utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<CashReceipt>> getById(
            @PathVariable Integer id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualizar un recibo de caja existente", description = "Permite actualizar los datos de un recibo de caja utilizando su ID")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<CashReceipt>> update(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateCashReceiptRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }
}