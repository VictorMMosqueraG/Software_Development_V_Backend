package development.v.development.infrastruture.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "categoria_plato")
@EntityListeners(AuditingEntityListener.class)
public class DishCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private Long catId;

    @Column(name = "cat_nombre", nullable = false, length = 100)
    private String catNombre;

    @Column(name = "cat_imagen", length = 255)
    private String catImagen;

    @Column(name = "cat_estado", nullable = false)
    private Integer catEstado;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getCatId() { return catId; }
    public void setCatId(Long catId) { this.catId = catId; }
    public String getCatNombre() { return catNombre; }
    public void setCatNombre(String catNombre) { this.catNombre = catNombre; }
    public String getCatImagen() { return catImagen; }
    public void setCatImagen(String catImagen) { this.catImagen = catImagen; }
    public Integer getCatEstado() { return catEstado; }
    public void setCatEstado(Integer catEstado) { this.catEstado = catEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
