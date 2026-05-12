package development.v.development.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Dish {
    private Long plaId;
    private Long catId;
    private String plaDescripcion;
    private String plaCodigo;
    private BigDecimal plaPrecio;
    private BigDecimal plaCosto;
    private String plaImagen;
    private Long estId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getPlaId() { return plaId; }
    public void setPlaId(Long plaId) { this.plaId = plaId; }
    public Long getCatId() { return catId; }
    public void setCatId(Long catId) { this.catId = catId; }
    public String getPlaDescripcion() { return plaDescripcion; }
    public void setPlaDescripcion(String plaDescripcion) { this.plaDescripcion = plaDescripcion; }
    public String getPlaCodigo() { return plaCodigo; }
    public void setPlaCodigo(String plaCodigo) { this.plaCodigo = plaCodigo; }
    public BigDecimal getPlaPrecio() { return plaPrecio; }
    public void setPlaPrecio(BigDecimal plaPrecio) { this.plaPrecio = plaPrecio; }
    public BigDecimal getPlaCosto() { return plaCosto; }
    public void setPlaCosto(BigDecimal plaCosto) { this.plaCosto = plaCosto; }
    public String getPlaImagen() { return plaImagen; }
    public void setPlaImagen(String plaImagen) { this.plaImagen = plaImagen; }
    public Long getEstId() { return estId; }
    public void setEstId(Long estId) { this.estId = estId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
