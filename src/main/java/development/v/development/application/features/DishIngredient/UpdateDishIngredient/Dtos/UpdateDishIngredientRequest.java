package development.v.development.application.features.DishIngredient.UpdateDishIngredient.Dtos;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class UpdateDishIngredientRequest {

    @NotNull(message = "El plato es requerido")
    @Schema(description = "ID del plato", example = "1")
    private Long plaId;

    @NotNull(message = "El insumo es requerido")
    @Schema(description = "ID del insumo", example = "1")
    private Long insId;

    @NotNull(message = "La cantidad es requerida")
    @Schema(description = "Cantidad del ingrediente", example = "0.500")
    private BigDecimal piCantidad;

    public Long getPlaId() { return plaId; }
    public void setPlaId(Long plaId) { this.plaId = plaId; }
    public Long getInsId() { return insId; }
    public void setInsId(Long insId) { this.insId = insId; }
    public BigDecimal getPiCantidad() { return piCantidad; }
    public void setPiCantidad(BigDecimal piCantidad) { this.piCantidad = piCantidad; }
}
