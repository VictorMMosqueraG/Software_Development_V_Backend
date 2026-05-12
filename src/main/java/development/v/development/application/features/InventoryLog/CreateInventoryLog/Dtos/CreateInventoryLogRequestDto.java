package development.v.development.application.features.InventoryLog.CreateInventoryLog.Dtos;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(description = "Request para crear un registro de inventario")
public class CreateInventoryLogRequestDto {

    @NotNull(message = "El insumo es requerido")
    @Schema(description = "ID del insumo", example = "1")
    private Long insId;

    @NotNull(message = "El usuario es requerido")
    @Schema(description = "ID del usuario", example = "1")
    private Long usuId;

    @NotBlank(message = "El tipo de log es requerido")
    @Pattern(regexp = "ENTRADA|SALIDA|AJUSTE|VENTA|MERMA", message = "El tipo debe ser ENTRADA, SALIDA, AJUSTE, VENTA o MERMA")
    @Schema(description = "Tipo de movimiento", example = "ENTRADA", allowableValues = {"ENTRADA", "SALIDA", "AJUSTE", "VENTA", "MERMA"})
    private String logTipo;

    @NotNull(message = "La cantidad es requerida")
    @Schema(description = "Cantidad del movimiento", example = "10.00")
    private BigDecimal logCantidad;

    @Schema(description = "Stock anterior", example = "50.00")
    private BigDecimal logStockAnt;

    @Schema(description = "Stock nuevo", example = "60.00")
    private BigDecimal logStockNvo;

    @Size(max = 255, message = "La nota no puede superar 255 caracteres")
    @Schema(description = "Nota del movimiento", example = "Compra de insumos")
    private String logNota;

    public Long getInsId() { return insId; }
    public void setInsId(Long insId) { this.insId = insId; }
    public Long getUsuId() { return usuId; }
    public void setUsuId(Long usuId) { this.usuId = usuId; }
    public String getLogTipo() { return logTipo; }
    public void setLogTipo(String logTipo) { this.logTipo = logTipo; }
    public BigDecimal getLogCantidad() { return logCantidad; }
    public void setLogCantidad(BigDecimal logCantidad) { this.logCantidad = logCantidad; }
    public BigDecimal getLogStockAnt() { return logStockAnt; }
    public void setLogStockAnt(BigDecimal logStockAnt) { this.logStockAnt = logStockAnt; }
    public BigDecimal getLogStockNvo() { return logStockNvo; }
    public void setLogStockNvo(BigDecimal logStockNvo) { this.logStockNvo = logStockNvo; }
    public String getLogNota() { return logNota; }
    public void setLogNota(String logNota) { this.logNota = logNota; }
}
