package development.v.development.application.cases.Invoice.GetInvoiceDashboard.Dtos;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * DTO (Query) que recibe los parámetros del endpoint de dashboard de facturas.
 *
 * Parámetros requeridos:
 *   - fechaInicio: Fecha inicio del periodo a consultar (formato: yyyy-MM-dd)
 *   - fechaFin:    Fecha fin del periodo a consultar (formato: yyyy-MM-dd)
 *
 * Ejemplo de uso:
 *   GET /api/v1/invoices/dashboard?fechaInicio=2026-01-01&fechaFin=2026-01-31
 */
public class InvoiceDashboardQuery {

    @NotBlank(message = "La fecha de inicio es obligatoria")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "El formato de fechaInicio debe ser yyyy-MM-dd")
    @Parameter(description = "Fecha inicio del periodo (yyyy-MM-dd)", example = "2026-01-01")
    private String fechaInicio;

    @NotBlank(message = "La fecha de fin es obligatoria")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "El formato de fechaFin debe ser yyyy-MM-dd")
    @Parameter(description = "Fecha fin del periodo (yyyy-MM-dd)", example = "2026-01-31")
    private String fechaFin;

    public String getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(String fechaInicio) { this.fechaInicio = fechaInicio; }

    public String getFechaFin() { return fechaFin; }
    public void setFechaFin(String fechaFin) { this.fechaFin = fechaFin; }
}

