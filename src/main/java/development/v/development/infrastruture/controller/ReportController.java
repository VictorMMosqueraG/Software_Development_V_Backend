package development.v.development.infrastruture.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import development.v.development.application.features.Report.GetDocumentDetail.GetDocumentDetailUseCase;
import development.v.development.application.features.Report.GetReportDetail.GetReportDetailUseCase;
import development.v.development.application.features.Report.GetReportDetail.Dtos.ReportDetailItemDto;
import development.v.development.application.features.Report.GetReportDetail.Dtos.ReportDetailQuery;
import development.v.development.application.features.Report.GetSalesReport.GetSalesReportUseCase;
import development.v.development.application.features.Report.GetSalesReport.Dtos.ReportQuery;
import development.v.development.application.features.Report.GetSalesReport.Dtos.SalesReportResponseDto;
import development.v.development.domain.models.CashReceipt;
import development.v.development.domain.models.Order;
import development.v.development.domain.responses.DataResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Reportes", description = "Consulta y trazabilidad de reportes del restaurante")
@RestController
@RequestMapping("/api/v1/reportes")
public class ReportController {

    private final GetSalesReportUseCase getSalesReportUseCase;
    private final GetReportDetailUseCase getReportDetailUseCase;
    private final GetDocumentDetailUseCase getDocumentDetailUseCase;

    public ReportController(
            GetSalesReportUseCase getSalesReportUseCase,
            GetReportDetailUseCase getReportDetailUseCase,
            GetDocumentDetailUseCase getDocumentDetailUseCase) {
        this.getSalesReportUseCase = getSalesReportUseCase;
        this.getReportDetailUseCase = getReportDetailUseCase;
        this.getDocumentDetailUseCase = getDocumentDetailUseCase;
    }

    @Operation(
        summary = "Consulta reporte de ventas de platos",
        description = "Obtiene el ranking top 5 de platos más vendidos, datos para gráficas (barras mensuales, "
                + "circular consolidado, barras agrupadas por sede y mes) e indicadores visuales. "
                + "Permite filtrar por rango de fechas, mesero, plato, estado y sede."
    )
    @GetMapping("/ventas-platos")
    public ResponseEntity<DataResultDto<SalesReportResponseDto>> getSalesReport(
            @ParameterObject @Valid @ModelAttribute ReportQuery query) {
        return ResponseEntity.ok(getSalesReportUseCase.execute(query));
    }

    @Operation(
        summary = "Consulta detalle/trazabilidad de platos seleccionados",
        description = "Dado uno o varios platos seleccionados del ranking, devuelve todos los documentos "
                + "asociados (recibos de caja, pedidos) con fecha, cliente, documento, total y demás información."
    )
    @PostMapping("/ventas-platos/detalle")
    public ResponseEntity<DataResultDto<List<ReportDetailItemDto>>> getReportDetail(
            @Valid @RequestBody ReportDetailQuery query) {
        return ResponseEntity.ok(getReportDetailUseCase.execute(query));
    }

    @Operation(
        summary = "Obtiene el detalle completo de un pedido",
        description = "Navega al documento origen de tipo pedido para ver su detalle completo."
    )
    @GetMapping("/documento/pedido/{id}")
    public ResponseEntity<DataResultDto<Order>> getOrderDetail(@PathVariable Long id) {
        return ResponseEntity.ok(getDocumentDetailUseCase.getOrderDetail(id));
    }

    @Operation(
        summary = "Obtiene el detalle completo de un recibo de caja",
        description = "Navega al documento origen de tipo recibo de caja/factura para ver su detalle completo."
    )
    @GetMapping("/documento/recibo-caja/{id}")
    public ResponseEntity<DataResultDto<CashReceipt>> getCashReceiptDetail(@PathVariable Long id) {
        return ResponseEntity.ok(getDocumentDetailUseCase.getCashReceiptDetail(id));
    }
}
