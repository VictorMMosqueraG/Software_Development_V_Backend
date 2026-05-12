package development.v.development.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InventoryLog {
    private Long logId;
    private Long insId;
    private Long usuId;
    private String logTipo;
    private BigDecimal logCantidad;
    private BigDecimal logStockAnt;
    private BigDecimal logStockNvo;
    private String logNota;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getLogId() { return logId; }
    public void setLogId(Long logId) { this.logId = logId; }
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
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
