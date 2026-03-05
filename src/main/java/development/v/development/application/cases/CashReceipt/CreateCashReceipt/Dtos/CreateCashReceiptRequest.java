package development.v.development.application.cases.CashReceipt.CreateCashReceipt.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Schema(description = "Request para crear un recibo de caja")
public class CreateCashReceiptRequest {

    @NotNull(message = "El ID del usuario es requerido")
    @Positive(message = "El ID del usuario debe ser un número positivo")
    @Schema(description = "ID del usuario que genera el recibo", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer usuId;

    @NotNull(message = "La fecha es requerida")
    @PastOrPresent(message = "La fecha no puede ser futura")
    @Schema(description = "Fecha del recibo", example = "2026-03-04", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate rcFecha;

    @NotNull(message = "El ID del pedido es requerido")
    @Positive(message = "El ID del pedido debe ser un número positivo")
    @Schema(description = "ID del pedido asociado al recibo", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer pedId;

    @NotNull(message = "El ID del cliente es requerido")
    @Positive(message = "El ID del cliente debe ser un número positivo")
    @Schema(description = "ID del cliente asociado al recibo", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer cliId;

    @NotNull(message = "El total es requerido")
    @Positive(message = "El total debe ser mayor a 0")
    @Schema(description = "Valor total del recibo", example = "50000.00", requiredMode = Schema.RequiredMode.REQUIRED)
    private Double rcTotal;

    @NotBlank(message = "La observación es requerida")
    @Size(min = 3, max = 360, message = "La observación debe tener entre 3 y 360 caracteres")
    @Schema(description = "Observaciones del recibo", example = "Pago en efectivo mesa 1", requiredMode = Schema.RequiredMode.REQUIRED)
    private String rcObservacion;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "ACTIVO|INACTIVO|ANULADO", message = "El estado debe ser ACTIVO, INACTIVO o ANULADO")
    @Schema(description = "Estado del recibo", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO", "ANULADO"}, requiredMode = Schema.RequiredMode.REQUIRED)
    private String rcEstado;

    public Integer getUsuId() { return usuId; }
    public void setUsuId(Integer usuId) { this.usuId = usuId; }

    public LocalDate getRcFecha() { return rcFecha; }
    public void setRcFecha(LocalDate rcFecha) { this.rcFecha = rcFecha; }

    public Integer getPedId() { return pedId; }
    public void setPedId(Integer pedId) { this.pedId = pedId; }

    public Integer getCliId() { return cliId; }
    public void setCliId(Integer cliId) { this.cliId = cliId; }

    public Double getRcTotal() { return rcTotal; }
    public void setRcTotal(Double rcTotal) { this.rcTotal = rcTotal; }

    public String getRcObservacion() { return rcObservacion; }
    public void setRcObservacion(String rcObservacion) { this.rcObservacion = rcObservacion; }

    public String getRcEstado() { return rcEstado; }
    public void setRcEstado(String rcEstado) { this.rcEstado = rcEstado; }
}