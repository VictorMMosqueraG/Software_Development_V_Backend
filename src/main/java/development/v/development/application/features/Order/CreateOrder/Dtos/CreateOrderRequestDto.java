package development.v.development.application.features.Order.CreateOrder.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Schema(description = "DTO para crear un pedido")
public class CreateOrderRequestDto {

    @Schema(description = "Fecha del pedido", example = "2024-01-15")
    private LocalDate pedFecha;

    @NotNull(message = "El ID del usuario es requerido")
    @Schema(description = "ID del usuario que crea el pedido", example = "1234")
    private Integer usuId;

    @NotBlank(message = "La mesa es requerida")
    @Schema(description = "Numero de mesa", example = "10")
    private String pedMesa;

    @NotNull(message = "El estado es requerido")
    @Schema(description = "ID del estado del pedido", example = "4")
    private Integer estId;

    @NotEmpty(message = "Debe incluir al menos un plato en el pedido")
    @Valid
    @Schema(description = "Lista de platos del pedido")
    private List<CreateOrderDetailDto> detalles;

    public LocalDate getPedFecha() { return pedFecha; }
    public void setPedFecha(LocalDate pedFecha) { this.pedFecha = pedFecha; }

    public Integer getUsuId() { return usuId; }
    public void setUsuId(Integer usuId) { this.usuId = usuId; }

    public String getPedMesa() { return pedMesa; }
    public void setPedMesa(String pedMesa) { this.pedMesa = pedMesa; }

    public Integer getEstId() { return estId; }
    public void setEstId(Integer estId) { this.estId = estId; }

    public List<CreateOrderDetailDto> getDetalles() { return detalles; }
    public void setDetalles(List<CreateOrderDetailDto> detalles) { this.detalles = detalles; }
}

