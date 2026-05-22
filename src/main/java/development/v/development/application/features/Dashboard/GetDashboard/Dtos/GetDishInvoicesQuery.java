package development.v.development.application.features.Dashboard.GetDashboard.Dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Filtros para consultar facturas relacionadas a platos")
public class GetDishInvoicesQuery {

    @Schema(description = "Fecha inicial del rango (yyyy-MM-dd)")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaInicio;

    @Schema(description = "Fecha final del rango (yyyy-MM-dd)")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaFin;

    @Schema(description = "Filtrar por mesero")
    private Integer meseroId;

    @Schema(description = "Filtrar por estado")
    private Integer estadoId;

    @Schema(description = "Filtrar por sede")
    private String sede;

    @Schema(description = "IDs de platos seleccionados (usar parametro repetido: platoIds=1&platoIds=2)")
    private List<Integer> platoIds = new ArrayList<>();

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

    public List<Integer> getPlatoIds() {
        return platoIds;
    }

    public void setPlatoIds(List<Integer> platoIds) {
        this.platoIds = platoIds;
    }
}

