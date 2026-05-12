package development.v.development.application.features.Report.GetSalesReport.Dtos;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Filtros para consulta de reportes de ventas")
public class ReportQuery {

    @NotNull(message = "La fecha de inicio es obligatoria")
    @Schema(description = "Fecha de inicio del rango (obligatoria)", example = "2025-01-01")
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de fin es obligatoria")
    @Schema(description = "Fecha de fin del rango (obligatoria)", example = "2025-12-31")
    private LocalDate fechaFin;

    @Schema(description = "Filtrar por mesero (usuario). Null o vacío = Todos")
    private Long usuId;

    @Schema(description = "Filtrar por plato. Null o vacío = Todos")
    private Long plaId;

    @Schema(description = "Filtrar por estado. Null o vacío = Todos")
    private Long estId;

    @Schema(description = "Filtrar por sede. Null o vacío = Todos")
    private Long sedeId;

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public Long getUsuId() { return usuId; }
    public void setUsuId(Long usuId) { this.usuId = usuId; }
    public Long getPlaId() { return plaId; }
    public void setPlaId(Long plaId) { this.plaId = plaId; }
    public Long getEstId() { return estId; }
    public void setEstId(Long estId) { this.estId = estId; }
    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
}
