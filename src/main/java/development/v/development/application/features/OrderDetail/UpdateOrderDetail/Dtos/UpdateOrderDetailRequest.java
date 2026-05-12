package development.v.development.application.features.OrderDetail.UpdateOrderDetail.Dtos;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateOrderDetailRequest {

    @NotNull(message = "El pedido es requerido")
    @Schema(description = "ID del pedido", example = "1")
    private Long pedId;

    @NotNull(message = "El plato es requerido")
    @Schema(description = "ID del plato", example = "1")
    private Long plaId;

    @NotNull(message = "La cantidad es requerida")
    @Schema(description = "Cantidad del detalle", example = "2")
    private Integer pedDetCant;

    @NotNull(message = "El precio es requerido")
    @Schema(description = "Precio del detalle", example = "15.50")
    private BigDecimal pedDetPrecio;

    @Size(max = 255, message = "Las observaciones no pueden superar 255 caracteres")
    @Schema(description = "Observaciones del detalle", example = "Sin cebolla")
    private String pedDetObser;

    @NotNull(message = "El estado es requerido")
    @Schema(description = "ID del estado", example = "1")
    private Long estId;

    public Long getPedId() { return pedId; }
    public void setPedId(Long pedId) { this.pedId = pedId; }
    public Long getPlaId() { return plaId; }
    public void setPlaId(Long plaId) { this.plaId = plaId; }
    public Integer getPedDetCant() { return pedDetCant; }
    public void setPedDetCant(Integer pedDetCant) { this.pedDetCant = pedDetCant; }
    public BigDecimal getPedDetPrecio() { return pedDetPrecio; }
    public void setPedDetPrecio(BigDecimal pedDetPrecio) { this.pedDetPrecio = pedDetPrecio; }
    public String getPedDetObser() { return pedDetObser; }
    public void setPedDetObser(String pedDetObser) { this.pedDetObser = pedDetObser; }
    public Long getEstId() { return estId; }
    public void setEstId(Long estId) { this.estId = estId; }
}
