package development.v.development.application.features.Report.GetReportDetail.Dtos;

import java.time.LocalDate;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Consulta de detalle/trazabilidad para los elementos seleccionados del ranking")
public class ReportDetailQuery {

    @NotEmpty(message = "Debe seleccionar al menos un elemento del ranking")
    @Schema(description = "Lista de IDs de platos seleccionados del ranking")
    private List<Long> plaIds;

    @NotNull(message = "La fecha de inicio es obligatoria")
    @Schema(description = "Fecha de inicio del rango")
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de fin es obligatoria")
    @Schema(description = "Fecha de fin del rango")
    private LocalDate fechaFin;

    @Schema(description = "Filtrar por sede")
    private Long sedeId;

    @Schema(description = "Filtrar por mesero")
    private Long usuId;

    public List<Long> getPlaIds() { return plaIds; }
    public void setPlaIds(List<Long> plaIds) { this.plaIds = plaIds; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public Long getUsuId() { return usuId; }
    public void setUsuId(Long usuId) { this.usuId = usuId; }
}
