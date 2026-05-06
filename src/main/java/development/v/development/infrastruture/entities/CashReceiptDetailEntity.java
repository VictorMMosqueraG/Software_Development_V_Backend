package development.v.development.infrastruture.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "recibo_caja_detalle")
@EntityListeners(AuditingEntityListener.class)
public class CashReceiptDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rcd_id")
    private Long rcdId;

    @Column(name = "rc_num", nullable = false)
    private Long rcNum;

    @Column(name = "pla_id", nullable = false)
    private Long plaId;

    @Column(name = "rcd_cantidad", nullable = false)
    private Integer rcdCantidad;

    @Column(name = "rcd_precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal rcdPrecio;

    @Column(name = "rcd_descuento", nullable = false, precision = 10, scale = 2)
    private BigDecimal rcdDescuento;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getRcdId() { return rcdId; }
    public void setRcdId(Long rcdId) { this.rcdId = rcdId; }

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

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
