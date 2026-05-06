package development.v.development.application.features.CashReceipt.CreateCashReceipt.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "Request para crear un recibo de caja")
public class CreateCashReceiptRequest {

    @NotNull(message = "El ID de la sede es requerido")
    @Positive(message = "El ID de la sede debe ser un número positivo")
    @Schema(description = "ID de la sede que emite el recibo", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long sedeId;

    @NotNull(message = "El ID del usuario es requerido")
    @Positive(message = "El ID del usuario debe ser un número positivo")
    @Schema(description = "ID del cajero que emite el recibo", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long usuId;

    @NotNull(message = "La fecha es requerida")
    @PastOrPresent(message = "La fecha no puede ser futura")
    @Schema(description = "Fecha del recibo", example = "2026-03-04", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate rcFecha;

    @NotNull(message = "El ID del pedido es requerido")
    @Positive(message = "El ID del pedido debe ser un número positivo")
    @Schema(description = "ID del pedido que se factura", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long pedId;

    @Positive(message = "El ID del cliente debe ser un número positivo")
    @Schema(description = "ID del cliente (NULL = Público General)", example = "1")
    private Long cliId;

    @NotNull(message = "El ID de la forma de pago es requerido")
    @Positive(message = "El ID de la forma de pago debe ser un número positivo")
    @Schema(description = "ID de la forma de pago", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long fpId;

    @NotNull(message = "El subtotal es requerido")
    @DecimalMin(value = "0.00", message = "El subtotal debe ser mayor o igual a 0")
    @Schema(description = "Subtotal antes de descuento", example = "50000.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal rcSubtotal;

    @NotNull(message = "El descuento es requerido")
    @DecimalMin(value = "0.00", message = "El descuento debe ser mayor o igual a 0")
    @Schema(description = "Descuento aplicado", example = "0.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal rcDescuento;

    @NotNull(message = "La propina es requerida")
    @DecimalMin(value = "0.00", message = "La propina debe ser mayor o igual a 0")
    @Schema(description = "Propina voluntaria", example = "5000.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal rcPropina;

    @NotNull(message = "El total es requerido")
    @DecimalMin(value = "0.01", message = "El total debe ser mayor a 0")
    @Schema(description = "Total a pagar", example = "55000.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal rcTotal;

    @DecimalMin(value = "0.00", message = "El monto recibido debe ser mayor o igual a 0")
    @Schema(description = "Monto recibido del cliente", example = "60000.00")
    private BigDecimal rcMontoRec;

    @NotNull(message = "El cambio es requerido")
    @DecimalMin(value = "0.00", message = "El cambio debe ser mayor o igual a 0")
    @Schema(description = "Cambio devuelto", example = "5000.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal rcCambio;

    @Size(max = 360, message = "La observación no debe exceder 360 caracteres")
    @Schema(description = "Observaciones de la factura", example = "Pago en efectivo mesa 1")
    private String rcObservacion;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "ACTIVO|ANULADO", message = "El estado debe ser ACTIVO o ANULADO")
    @Schema(description = "Estado del recibo", example = "ACTIVO", allowableValues = {"ACTIVO", "ANULADO"}, requiredMode = Schema.RequiredMode.REQUIRED)
    private String rcEstado;

    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }

    public Long getUsuId() { return usuId; }
    public void setUsuId(Long usuId) { this.usuId = usuId; }

    public LocalDate getRcFecha() { return rcFecha; }
    public void setRcFecha(LocalDate rcFecha) { this.rcFecha = rcFecha; }

    public Long getPedId() { return pedId; }
    public void setPedId(Long pedId) { this.pedId = pedId; }

    public Long getCliId() { return cliId; }
    public void setCliId(Long cliId) { this.cliId = cliId; }

    public Long getFpId() { return fpId; }
    public void setFpId(Long fpId) { this.fpId = fpId; }

    public BigDecimal getRcSubtotal() { return rcSubtotal; }
    public void setRcSubtotal(BigDecimal rcSubtotal) { this.rcSubtotal = rcSubtotal; }

    public BigDecimal getRcDescuento() { return rcDescuento; }
    public void setRcDescuento(BigDecimal rcDescuento) { this.rcDescuento = rcDescuento; }

    public BigDecimal getRcPropina() { return rcPropina; }
    public void setRcPropina(BigDecimal rcPropina) { this.rcPropina = rcPropina; }

    public BigDecimal getRcTotal() { return rcTotal; }
    public void setRcTotal(BigDecimal rcTotal) { this.rcTotal = rcTotal; }

    public BigDecimal getRcMontoRec() { return rcMontoRec; }
    public void setRcMontoRec(BigDecimal rcMontoRec) { this.rcMontoRec = rcMontoRec; }

    public BigDecimal getRcCambio() { return rcCambio; }
    public void setRcCambio(BigDecimal rcCambio) { this.rcCambio = rcCambio; }

    public String getRcObservacion() { return rcObservacion; }
    public void setRcObservacion(String rcObservacion) { this.rcObservacion = rcObservacion; }

    public String getRcEstado() { return rcEstado; }
    public void setRcEstado(String rcEstado) { this.rcEstado = rcEstado; }
}
