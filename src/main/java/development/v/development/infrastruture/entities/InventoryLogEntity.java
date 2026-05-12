package development.v.development.infrastruture.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import development.v.development.infrastruture.enums.InventoryLogType;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "inventario_log")
@EntityListeners(AuditingEntityListener.class)
public class InventoryLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long logId;

    @Column(name = "ins_id", nullable = false)
    private Long insId;

    @Column(name = "usu_id", nullable = false)
    private Long usuId;

    @Enumerated(EnumType.STRING)
    @Column(name = "log_tipo", nullable = false)
    private InventoryLogType logTipo;

    @Column(name = "log_cantidad", nullable = false)
    private BigDecimal logCantidad;

    @Column(name = "log_stock_ant")
    private BigDecimal logStockAnt;

    @Column(name = "log_stock_nvo")
    private BigDecimal logStockNvo;

    @Column(name = "log_nota", length = 255)
    private String logNota;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getLogId() { return logId; }
    public void setLogId(Long logId) { this.logId = logId; }
    public Long getInsId() { return insId; }
    public void setInsId(Long insId) { this.insId = insId; }
    public Long getUsuId() { return usuId; }
    public void setUsuId(Long usuId) { this.usuId = usuId; }
    public InventoryLogType getLogTipo() { return logTipo; }
    public void setLogTipo(InventoryLogType logTipo) { this.logTipo = logTipo; }
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
