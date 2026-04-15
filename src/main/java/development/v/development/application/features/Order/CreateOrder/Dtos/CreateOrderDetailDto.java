package development.v.development.application.features.Order.CreateOrder.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Schema(description = "DTO para el detalle de un pedido")
public class CreateOrderDetailDto {

    @NotNull(message = "El ID del plato es requerido")
    @Schema(description = "ID del plato", example = "1")
    private Integer plaId;

    @NotNull(message = "La cantidad es requerida")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    @Schema(description = "Cantidad de platos", example = "2")
    private Integer cantidad;

    @NotNull(message = "El precio es requerido")
    @Schema(description = "Precio del plato", example = "12000")
    private Float precio;

    @Schema(description = "Observaciones del plato", example = "Sin cebolla")
    private String observacion;

    public Integer getPlaId() { return plaId; }
    public void setPlaId(Integer plaId) { this.plaId = plaId; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public Float getPrecio() { return precio; }
    public void setPrecio(Float precio) { this.precio = precio; }

    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }
}

