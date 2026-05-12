package development.v.development.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DishIngredient {
    private Long piId;
    private Long plaId;
    private Long insId;
    private BigDecimal piCantidad;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getPiId() { return piId; }
    public void setPiId(Long piId) { this.piId = piId; }
    public Long getPlaId() { return plaId; }
    public void setPlaId(Long plaId) { this.plaId = plaId; }
    public Long getInsId() { return insId; }
    public void setInsId(Long insId) { this.insId = insId; }
    public BigDecimal getPiCantidad() { return piCantidad; }
    public void setPiCantidad(BigDecimal piCantidad) { this.piCantidad = piCantidad; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
