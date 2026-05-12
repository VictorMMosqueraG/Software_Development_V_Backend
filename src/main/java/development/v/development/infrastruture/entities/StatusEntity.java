package development.v.development.infrastruture.entities;

import java.time.LocalDateTime;

import development.v.development.infrastruture.enums.StatusStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "estado")
@EntityListeners(AuditingEntityListener.class)
public class StatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "est_id")
    private Long estId;

    @Column(name = "est_descripcion", nullable = false, length = 60)
    private String estDescripcion;

    @Column(name = "tes_id", nullable = false)
    private Long tesId;

    @Enumerated(EnumType.STRING)
    @Column(name = "est_estado", nullable = false)
    private StatusStatus estEstado;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getEstId() { return estId; }
    public void setEstId(Long estId) { this.estId = estId; }
    public String getEstDescripcion() { return estDescripcion; }
    public void setEstDescripcion(String estDescripcion) { this.estDescripcion = estDescripcion; }
    public Long getTesId() { return tesId; }
    public void setTesId(Long tesId) { this.tesId = tesId; }
    public StatusStatus getEstEstado() { return estEstado; }
    public void setEstEstado(StatusStatus estEstado) { this.estEstado = estEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
