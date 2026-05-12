package development.v.development.infrastruture.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import development.v.development.application.features.PaymentMethod.CreatePaymentMethod.CreatePaymentMethodUseCase;
import development.v.development.application.features.PaymentMethod.CreatePaymentMethod.Dtos.CreatePaymentMethodRequestDto;
import development.v.development.application.features.PaymentMethod.DeletePaymentMethod.DeletePaymentMethodUseCase;
import development.v.development.application.features.PaymentMethod.GetAllPaymentMethod.GetAllPaymentMethodUseCase;
import development.v.development.application.features.PaymentMethod.GetAllPaymentMethod.Dtos.GetAllPaymentMethodQuery;
import development.v.development.application.features.PaymentMethod.GetPaymentMethodById.GetPaymentMethodByIdUseCase;
import development.v.development.application.features.PaymentMethod.UpdatePaymentMethod.UpdatePaymentMethodUseCase;
import development.v.development.application.features.PaymentMethod.UpdatePaymentMethod.Dtos.UpdatePaymentMethodRequest;
import development.v.development.domain.models.PaymentMethod;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "PaymentMethod", description = "Administra las formas de pago")
@RestController
@RequestMapping("/api/v1/payment-methods")
public class PaymentMethodController {

    private final CreatePaymentMethodUseCase createUseCase;
    private final GetAllPaymentMethodUseCase getAllUseCase;
    private final GetPaymentMethodByIdUseCase getByIdUseCase;
    private final UpdatePaymentMethodUseCase updateUseCase;
    private final DeletePaymentMethodUseCase deleteUseCase;

    public PaymentMethodController(
        CreatePaymentMethodUseCase createUseCase,
        GetAllPaymentMethodUseCase getAllUseCase,
        GetPaymentMethodByIdUseCase getByIdUseCase,
        UpdatePaymentMethodUseCase updateUseCase,
        DeletePaymentMethodUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea una nueva forma de pago")
    @PostMapping
    public ResponseEntity<DataResultDto<PaymentMethod>> create(
            @Valid @RequestBody CreatePaymentMethodRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de formas de pago")
    @GetMapping
    public ResponseEntity<PaginatedResultDto<List<PaymentMethod>>> getAll(
            @ParameterObject @Valid @ModelAttribute GetAllPaymentMethodQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene una forma de pago por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<PaymentMethod>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza una forma de pago existente")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<PaymentMethod>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdatePaymentMethodRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina una forma de pago por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<PaymentMethod>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
