package development.v.development.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDetail {
    private Long pedDetId;
    private Long pedId;
    private Long plaId;
    private Integer pedDetCant;
    private BigDecimal pedDetPrecio;
    private String pedDetObser;
    private Long estId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getPedDetId() { return pedDetId; }
    public void setPedDetId(Long pedDetId) { this.pedDetId = pedDetId; }
    public Long getPedId() { return pedId; }
    public void setPedId(Long pedId) { this.pedId = pedId; }
    public Long getPlaId() { return plaId; }
    public void setPlaId(Long plaId) { this.plaId = plaId; }
    public Integer getPedDetCant() { return pedDetCant; }
    public void setPedDetCant(Integer pedDetCant) { this.pedDetCant = pedDetCant; }
    public BigDecimal getPedDetPrecio() { return pedDetPrecio; }
    public void setPedDetPrecio(BigDecimal pedDetPrecio) { this.pedDetPrecio = pedDetPrecio; }
    public String getPedDetObser() { return pedDetObser; }
    public void setPedDetObser(String pedDetObser) { this.pedDetObser = pedDetObser; }
    public Long getEstId() { return estId; }
    public void setEstId(Long estId) { this.estId = estId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
