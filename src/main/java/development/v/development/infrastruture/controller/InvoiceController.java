package development.v.development.infrastruture.controller;

import development.v.development.application.cases.Invoice.GetInvoiceDashboard.GetInvoiceDashboardUseCase;
import development.v.development.application.cases.Invoice.GetInvoiceDashboard.Dtos.InvoiceDashboardQuery;
import development.v.development.domain.models.InvoiceDashboard;
import development.v.development.domain.responses.DataResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para el Dashboard de Facturas.
 *
 * ============================================================================
 * ENDPOINT
 * ============================================================================
 *   GET /api/v1/invoices/dashboard?fechaInicio={yyyy-MM-dd}&fechaFin={yyyy-MM-dd}
 *
 * ============================================================================
 * DESCRIPCIÓN
 * ============================================================================
 * API de SOLO CONSULTA que retorna en una sola petición tres bloques de datos:
 *
 *  1. "registros":                Tabla con todas las facturas del periodo
 *                                 (factId, factFecha, clienteNombre, factTotal, factEstado)
 *
 *  2. "clienteMayorFacturacion":  El cliente con el mayor valor facturado
 *                                 considerando SOLO facturas con estado "Activo"
 *                                 (clienteNombre, totalFacturado)
 *
 *  3. "ventasPorDia":             Ventas consolidadas por día para graficar
 *                                 considerando SOLO facturas con estado "Activo"
 *                                 (fecha, totalVenta)
 *
 * ============================================================================
 * EJEMPLO DE USO
 * ============================================================================
 *   GET /api/v1/invoices/dashboard?fechaInicio=2026-01-01&fechaFin=2026-01-31
 *
 *   Respuesta:
 *   {
 *     "message": "Operación realizada con éxito",
 *     "results": {
 *       "registros": [
 *         { "factId": 1, "factFecha": "2026-01-01", "clienteNombre": "FUNDIMOS TYC", "factTotal": 50000, "factEstado": "Activo" },
 *         { "factId": 5, "factFecha": "2026-01-01", "clienteNombre": "Bronalco", "factTotal": 52000, "factEstado": "Anulada" }
 *       ],
 *       "clienteMayorFacturacion": {
 *         "clienteNombre": "Bronalco",
 *         "totalFacturado": 286000
 *       },
 *       "ventasPorDia": [
 *         { "fecha": "2026-01-01", "totalVenta": 178000 },
 *         { "fecha": "2026-01-02", "totalVenta": 119000 },
 *         { "fecha": "2026-01-03", "totalVenta": 286000 }
 *       ]
 *     }
 *   }
 *
 * ============================================================================
 * NOTA SOBRE BASE DE DATOS
 * ============================================================================
 * Este endpoint trabaja con la base de datos bd_factura.
 * Asegúrese de configurar en application.properties:
 *   spring.datasource.url=jdbc:mysql://localhost:3306/bd_factura
 * ============================================================================
 */
@RestController
@RequestMapping("/api/v1/invoices")
@Tag(name = "Invoice Dashboard", description = "Dashboard de facturas - API de solo consulta")
public class InvoiceController {

    private final GetInvoiceDashboardUseCase getInvoiceDashboardUseCase;

    public InvoiceController(GetInvoiceDashboardUseCase getInvoiceDashboardUseCase) {
        this.getInvoiceDashboardUseCase = getInvoiceDashboardUseCase;
    }


    @GetMapping("/dashboard")
    public ResponseEntity<DataResultDto<InvoiceDashboard>> getDashboard(
            @ParameterObject @Valid @ModelAttribute InvoiceDashboardQuery query) {
        return ResponseEntity.ok(getInvoiceDashboardUseCase.execute(query));
    }
}

