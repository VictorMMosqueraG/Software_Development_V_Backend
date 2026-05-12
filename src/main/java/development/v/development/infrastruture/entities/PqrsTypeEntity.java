package development.v.development.infrastruture.entities;

import java.time.LocalDateTime;

import development.v.development.infrastruture.enums.PqrsTypeStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tipo_tpqrs")
@EntityListeners(AuditingEntityListener.class)
public class PqrsTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tpqrs_id")
    private Long tpqrsId;

    @Column(name = "tpqrs_descripcion", nullable = false, length = 60)
    private String tpqrsDescripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "tpqrs_estado", nullable = false)
    private PqrsTypeStatus tpqrsEstado;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getTpqrsId() { return tpqrsId; }
    public void setTpqrsId(Long tpqrsId) { this.tpqrsId = tpqrsId; }
    public String getTpqrsDescripcion() { return tpqrsDescripcion; }
    public void setTpqrsDescripcion(String tpqrsDescripcion) { this.tpqrsDescripcion = tpqrsDescripcion; }
    public PqrsTypeStatus getTpqrsEstado() { return tpqrsEstado; }
    public void setTpqrsEstado(PqrsTypeStatus tpqrsEstado) { this.tpqrsEstado = tpqrsEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
