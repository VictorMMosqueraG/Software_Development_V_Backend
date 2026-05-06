package development.v.development.application.features.CashReceiptDetail.CreateCashReceiptDetail.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Schema(description = "Request para crear un detalle de recibo de caja")
public class CreateCashReceiptDetailRequest {

    @NotNull(message = "El número de recibo es requerido")
    @Positive(message = "El número de recibo debe ser un número positivo")
    @Schema(description = "Número del recibo al que pertenece", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long rcNum;

    @NotNull(message = "El ID del plato es requerido")
    @Positive(message = "El ID del plato debe ser un número positivo")
    @Schema(description = "ID del plato facturado", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long plaId;

    @NotNull(message = "La cantidad es requerida")
    @Positive(message = "La cantidad debe ser mayor a 0")
    @Schema(description = "Cantidad del plato", example = "2", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer rcdCantidad;

    @NotNull(message = "El precio es requerido")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
    @Schema(description = "Precio unitario en la factura", example = "25000.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal rcdPrecio;

    @NotNull(message = "El descuento es requerido")
    @DecimalMin(value = "0.00", message = "El descuento debe ser mayor o igual a 0")
    @Schema(description = "Descuento por línea", example = "0.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal rcdDescuento;

    public Long getRcNum() { return rcNum; }
    public void setRcNum(Long rcNum) { this.rcNum = rcNum; }

    public Long getPlaId() { return plaId; }
    public void setPlaId(Long plaId) { this.plaId = plaId; }

    public Integer getRcdCantidad() { return rcdCantidad; }
    public void setRcdCantidad(Integer rcdCantidad) { this.rcdCantidad = rcdCantidad; }

    public BigDecimal getRcdPrecio() { return rcdPrecio; }
    public void setRcdPrecio(BigDecimal rcdPrecio) { this.rcdPrecio = rcdPrecio; }

    public BigDecimal getRcdDescuento() { return rcdDescuento; }
    public void setRcdDescuento(BigDecimal rcdDescuento) { this.rcdDescuento = rcdDescuento; }
}
