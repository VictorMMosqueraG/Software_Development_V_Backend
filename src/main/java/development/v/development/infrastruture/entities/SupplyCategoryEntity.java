package development.v.development.infrastruture.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "categoria_insumo")
@EntityListeners(AuditingEntityListener.class)
public class SupplyCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cins_id")
    private Long cinsId;

    @Column(name = "cins_nombre", nullable = false, length = 100)
    private String cinsNombre;

    @Column(name = "cins_imagen", length = 255)
    private String cinsImagen;

    @Column(name = "cins_estado", nullable = false)
    private Integer cinsEstado;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getCinsId() { return cinsId; }
    public void setCinsId(Long cinsId) { this.cinsId = cinsId; }
    public String getCinsNombre() { return cinsNombre; }
    public void setCinsNombre(String cinsNombre) { this.cinsNombre = cinsNombre; }
    public String getCinsImagen() { return cinsImagen; }
    public void setCinsImagen(String cinsImagen) { this.cinsImagen = cinsImagen; }
    public Integer getCinsEstado() { return cinsEstado; }
    public void setCinsEstado(Integer cinsEstado) { this.cinsEstado = cinsEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
