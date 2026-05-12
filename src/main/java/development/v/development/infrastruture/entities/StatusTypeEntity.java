package development.v.development.infrastruture.entities;

import java.time.LocalDateTime;

import development.v.development.infrastruture.enums.StatusTypeStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tipo_estado")
@EntityListeners(AuditingEntityListener.class)
public class StatusTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tes_id")
    private Long tesId;

    @Column(name = "tes_descripcion", nullable = false, length = 50)
    private String tesDescripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "tes_estado", nullable = false)
    private StatusTypeStatus tesEstado;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getTesId() { return tesId; }
    public void setTesId(Long tesId) { this.tesId = tesId; }
    public String getTesDescripcion() { return tesDescripcion; }
    public void setTesDescripcion(String tesDescripcion) { this.tesDescripcion = tesDescripcion; }
    public StatusTypeStatus getTesEstado() { return tesEstado; }
    public void setTesEstado(StatusTypeStatus tesEstado) { this.tesEstado = tesEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
