package development.v.development.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CashReceiptDetail {
    private Long rcdId;
    private Long rcNum;
    private Long plaId;
    private Integer rcdCantidad;
    private BigDecimal rcdPrecio;
    private BigDecimal rcdDescuento;
    private LocalDateTime createdAt;
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
