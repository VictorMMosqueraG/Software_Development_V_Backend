package development.v.development.application.features.Order.UpdateOrder.Dtos;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateOrderRequest {

    @NotNull(message = "La sede es requerida")
    @Schema(description = "ID de la sede", example = "1")
    private Long sedeId;

    @NotNull(message = "La fecha es requerida")
    @Schema(description = "Fecha del pedido", example = "2026-05-11")
    private LocalDate pedFecha;

    @NotNull(message = "El usuario es requerido")
    @Schema(description = "ID del usuario", example = "1")
    private Long usuId;

    @NotNull(message = "La mesa es requerida")
    @Schema(description = "ID de la mesa", example = "1")
    private Long mesaId;

    @NotNull(message = "El estado es requerido")
    @Schema(description = "ID del estado", example = "1")
    private Long estId;

    @Size(max = 360, message = "Las observaciones no pueden superar 360 caracteres")
    @Schema(description = "Observaciones del pedido", example = "Sin cebolla")
    private String pedObs;

    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public LocalDate getPedFecha() { return pedFecha; }
    public void setPedFecha(LocalDate pedFecha) { this.pedFecha = pedFecha; }
    public Long getUsuId() { return usuId; }
    public void setUsuId(Long usuId) { this.usuId = usuId; }
    public Long getMesaId() { return mesaId; }
    public void setMesaId(Long mesaId) { this.mesaId = mesaId; }
    public Long getEstId() { return estId; }
    public void setEstId(Long estId) { this.estId = estId; }
    public String getPedObs() { return pedObs; }
    public void setPedObs(String pedObs) { this.pedObs = pedObs; }
}
