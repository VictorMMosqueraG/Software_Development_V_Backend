package development.v.development.infrastruture.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import development.v.development.application.cases.CashReceipt.CreateCashReceipt.CreateCashReceiptUseCase;
import development.v.development.application.cases.CashReceipt.CreateCashReceipt.Dtos.CreateCashReceiptRequest;
import development.v.development.domain.models.CashReceipt;
import development.v.development.domain.responses.DataResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/cash-receipt")
@Tag(name = "CashReceipt", description = "Administra los recibos de caja")
public class CashReceiptController {
    
    private final CreateCashReceiptUseCase createUseCase;

    public CashReceiptController(CreateCashReceiptUseCase createUseCase) {
        this.createUseCase = createUseCase;
    }

    @Operation(summary = "Crea un nuevo recibo de caja", description = "Permite crear un nuevo recibo de caja con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<CashReceipt>> create(@Valid @RequestBody CreateCashReceiptRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request));
    }
    
}
