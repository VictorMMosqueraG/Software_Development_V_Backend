package development.v.development.application.features.Order.UpdateOrder.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "DTO para actualizar un pedido")
public class UpdateOrderRequestDto {

    @Schema(description = "Fecha del pedido", example = "2024-01-15")
    private LocalDate pedFecha;

    @Schema(description = "ID del usuario", example = "1234")
    private Integer usuId;

    @Schema(description = "Numero de mesa", example = "10")
    private String pedMesa;

    @Schema(description = "ID del estado del pedido", example = "5")
    private Integer estId;

    public LocalDate getPedFecha() { return pedFecha; }
    public void setPedFecha(LocalDate pedFecha) { this.pedFecha = pedFecha; }

    public Integer getUsuId() { return usuId; }
    public void setUsuId(Integer usuId) { this.usuId = usuId; }

    public String getPedMesa() { return pedMesa; }
    public void setPedMesa(String pedMesa) { this.pedMesa = pedMesa; }

    public Integer getEstId() { return estId; }
    public void setEstId(Integer estId) { this.estId = estId; }
}

