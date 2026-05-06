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

import development.v.development.application.features.CashReceiptDetail.CreateCashReceiptDetail.CreateCashReceiptDetailUseCase;
import development.v.development.application.features.CashReceiptDetail.CreateCashReceiptDetail.Dtos.CreateCashReceiptDetailRequest;
import development.v.development.application.features.CashReceiptDetail.DeleteCashReceiptDetail.DeleteCashReceiptDetailUseCase;
import development.v.development.application.features.CashReceiptDetail.FindAllCashReceiptDetail.GetAllCashReceiptDetailUseCase;
import development.v.development.application.features.CashReceiptDetail.FindAllCashReceiptDetail.Dtos.GetAllCashReceiptDetailQuery;
import development.v.development.application.features.CashReceiptDetail.GetCashReceiptDetailById.GetCashReceiptDetailByIdUseCase;
import development.v.development.application.features.CashReceiptDetail.UpdateCashReceiptDetail.UpdateCashReceiptDetailUseCase;
import development.v.development.application.features.CashReceiptDetail.UpdateCashReceiptDetail.Dtos.UpdateCashReceiptDetailRequest;
import development.v.development.domain.models.CashReceiptDetail;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/cash-receipt-detail")
@Tag(name = "CashReceiptDetail", description = "Administra los detalles de recibos de caja")
public class CashReceiptDetailController {

    private final CreateCashReceiptDetailUseCase createUseCase;
    private final GetAllCashReceiptDetailUseCase getAllUseCase;
    private final GetCashReceiptDetailByIdUseCase getByIdUseCase;
    private final UpdateCashReceiptDetailUseCase updateUseCase;
    private final DeleteCashReceiptDetailUseCase deleteUseCase;

    public CashReceiptDetailController(
            CreateCashReceiptDetailUseCase createUseCase,
            GetAllCashReceiptDetailUseCase getAllUseCase,
            GetCashReceiptDetailByIdUseCase getByIdUseCase,
            UpdateCashReceiptDetailUseCase updateUseCase,
            DeleteCashReceiptDetailUseCase deleteUseCase) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea un nuevo detalle de recibo de caja", description = "Permite crear una línea de detalle para un recibo de caja existente")
    @PostMapping
    public ResponseEntity<DataResultDto<CashReceiptDetail>> create(@Valid @RequestBody CreateCashReceiptDetailRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtener todos los detalles de recibo paginados", description = "Retorna una lista paginada de detalles de recibo con filtros opcionales")
    @GetMapping
    public ResponseEntity<PaginatedResultDto<List<CashReceiptDetail>>> getAll(
            @ParameterObject @Valid @ModelAttribute GetAllCashReceiptDetailQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtener un detalle de recibo por ID", description = "Retorna un detalle de recibo específico utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<CashReceiptDetail>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualizar un detalle de recibo existente", description = "Permite actualizar los datos de un detalle de recibo utilizando su ID")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<CashReceiptDetail>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateCashReceiptDetailRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Eliminar un detalle de recibo", description = "Permite eliminar un detalle de recibo utilizando su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<CashReceiptDetail>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
