package development.v.development.infrastruture.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import development.v.development.application.cases.CashReceipt.CreateCashReceipt.CreateCashReceiptUseCase;
import development.v.development.application.cases.CashReceipt.CreateCashReceipt.Dtos.CreateCashReceiptRequest;
import development.v.development.application.cases.CashReceipt.FindAllCashReceipt.GetAllCashReceiptUseCase;
import development.v.development.application.cases.CashReceipt.FindAllCashReceipt.Dtos.GetAllCashReceiptQuery;
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

    public CashReceiptController(CreateCashReceiptUseCase createUseCase, GetAllCashReceiptUseCase getAllUseCase) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
    }

    @Operation(
        summary = "Crea un nuevo recibo de caja",
        description = "Permite crear un nuevo recibo de caja con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<CashReceipt>> create(@Valid @RequestBody CreateCashReceiptRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request));
    }

    @Operation(
        summary = "Obtener todos los recibos de caja paginados",
        description = "Retorna una lista paginada de recibos de caja con filtros opcionales")
    @GetMapping
    public ResponseEntity<PaginatedResultDto<List<CashReceipt>>> getAll(
            @ParameterObject @Valid @ModelAttribute GetAllCashReceiptQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }
}