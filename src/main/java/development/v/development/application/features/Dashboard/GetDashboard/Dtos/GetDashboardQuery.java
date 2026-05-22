package development.v.development.application.features.Dashboard.GetDashboard.Dtos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Filtros para consultar el dashboard")
public class GetDashboardQuery {

    @Schema(description = "Fecha inicial del rango (yyyy-MM-dd)")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaInicio;

    @Schema(description = "Fecha final del rango (yyyy-MM-dd)")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaFin;

    @Schema(description = "Filtrar por mesero")
    private Integer meseroId;

    @Schema(description = "Filtrar por plato")
    private Integer platoId;

    @Schema(description = "Filtrar por estado")
    private Integer estadoId;

    @Schema(description = "Filtrar por sede")
    private String sede;

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getMeseroId() {
        return meseroId;
    }

    public void setMeseroId(Integer meseroId) {
        this.meseroId = meseroId;
    }

    public Integer getPlatoId() {
        return platoId;
    }

    public void setPlatoId(Integer platoId) {
        this.platoId = platoId;
    }

    public Integer getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Integer estadoId) {
        this.estadoId = estadoId;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }
}

