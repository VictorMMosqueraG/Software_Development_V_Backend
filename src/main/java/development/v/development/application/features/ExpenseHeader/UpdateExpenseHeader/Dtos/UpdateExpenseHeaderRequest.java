package development.v.development.application.features.ExpenseHeader.UpdateExpenseHeader.Dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

public class UpdateExpenseHeaderRequest {

    @NotNull(message = "La sede es requerida")
    @Schema(description = "ID de la sede", example = "1")
    private Long sedeId;

    @NotNull(message = "El numero de egreso es requerido")
    @Schema(description = "Numero de egreso", example = "1001")
    private Long noEgreso;

    @NotNull(message = "La fecha del documento es requerida")
    @Schema(description = "Fecha del documento", example = "2026-01-15")
    private LocalDate fechaDocumento;

    @NotBlank(message = "La identificacion del tercero es requerida")
    @Size(max = 20, message = "La identificacion del tercero no puede superar 20 caracteres")
    @Schema(description = "Identificacion del tercero", example = "1234567890")
    private String terceroIdentificacion;

    @Size(max = 150, message = "El nombre del tercero no puede superar 150 caracteres")
    @Schema(description = "Nombre del tercero", example = "Juan Perez")
    private String terceroNombre;

    @NotBlank(message = "El detalle es requerido")
    @Size(max = 250, message = "El detalle no puede superar 250 caracteres")
    @Schema(description = "Detalle del egreso", example = "Pago de servicios")
    private String detalle;

    @NotNull(message = "La forma de pago es requerida")
    @Schema(description = "ID de la forma de pago", example = "1")
    private Long fpId;

    @NotNull(message = "El concepto de egreso es requerido")
    @Schema(description = "ID del concepto de egreso", example = "1")
    private Long conId;

    @NotBlank(message = "El numero de documento es requerido")
    @Size(max = 30, message = "El numero de documento no puede superar 30 caracteres")
    @Schema(description = "Numero de documento", example = "FAC-001")
    private String noDocumento;

    @NotNull(message = "El valor del egreso es requerido")
    @DecimalMin(value = "0.00", message = "El valor del egreso debe ser mayor o igual a 0")
    @Digits(integer = 14, fraction = 2, message = "El valor del egreso no puede superar 14 digitos enteros y 2 decimales")
    @Schema(description = "Valor del egreso", example = "150000.50")
    private BigDecimal valorEgreso;

    @NotNull(message = "El usuario es requerido")
    @Schema(description = "ID del usuario", example = "1")
    private Long usuId;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "ACTIVO|ANULADO", message = "El estado debe ser ACTIVO o ANULADO")
    @Schema(description = "Estado del egreso", example = "ACTIVO", allowableValues = {"ACTIVO", "ANULADO"})
    private String egrEstado;

    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public Long getNoEgreso() { return noEgreso; }
    public void setNoEgreso(Long noEgreso) { this.noEgreso = noEgreso; }
    public LocalDate getFechaDocumento() { return fechaDocumento; }
    public void setFechaDocumento(LocalDate fechaDocumento) { this.fechaDocumento = fechaDocumento; }
    public String getTerceroIdentificacion() { return terceroIdentificacion; }
    public void setTerceroIdentificacion(String terceroIdentificacion) { this.terceroIdentificacion = terceroIdentificacion; }
    public String getTerceroNombre() { return terceroNombre; }
    public void setTerceroNombre(String terceroNombre) { this.terceroNombre = terceroNombre; }
    public String getDetalle() { return detalle; }
    public void setDetalle(String detalle) { this.detalle = detalle; }
    public Long getFpId() { return fpId; }
    public void setFpId(Long fpId) { this.fpId = fpId; }
    public Long getConId() { return conId; }
    public void setConId(Long conId) { this.conId = conId; }
    public String getNoDocumento() { return noDocumento; }
    public void setNoDocumento(String noDocumento) { this.noDocumento = noDocumento; }
    public BigDecimal getValorEgreso() { return valorEgreso; }
    public void setValorEgreso(BigDecimal valorEgreso) { this.valorEgreso = valorEgreso; }
    public Long getUsuId() { return usuId; }
    public void setUsuId(Long usuId) { this.usuId = usuId; }
    public String getEgrEstado() { return egrEstado; }
    public void setEgrEstado(String egrEstado) { this.egrEstado = egrEstado; }
}
