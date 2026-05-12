package development.v.development.infrastruture.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "plato")
@EntityListeners(AuditingEntityListener.class)
public class DishEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pla_id")
    private Long plaId;

    @Column(name = "cat_id", nullable = false)
    private Long catId;

    @Column(name = "pla_descripcion", nullable = false, length = 150)
    private String plaDescripcion;

    @Column(name = "pla_codigo", length = 20)
    private String plaCodigo;

    @Column(name = "pla_precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal plaPrecio;

    @Column(name = "pla_costo", precision = 10, scale = 2)
    private BigDecimal plaCosto;

    @Column(name = "pla_imagen", length = 255)
    private String plaImagen;

    @Column(name = "est_id", nullable = false)
    private Long estId;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
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
