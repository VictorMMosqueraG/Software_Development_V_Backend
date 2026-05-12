package development.v.development.infrastruture.entities;

import java.time.LocalDateTime;

import development.v.development.infrastruture.enums.ProfileStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "perfil")
@EntityListeners(AuditingEntityListener.class)
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perf_id")
    private Long perfId;

    @Column(name = "perf_descripcion", nullable = false, length = 60)
    private String perfDescripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "perf_estado", nullable = false)
    private ProfileStatus perfEstado;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getPerfId() { return perfId; }
    public void setPerfId(Long perfId) { this.perfId = perfId; }
    public String getPerfDescripcion() { return perfDescripcion; }
    public void setPerfDescripcion(String perfDescripcion) { this.perfDescripcion = perfDescripcion; }
    public ProfileStatus getPerfEstado() { return perfEstado; }
    public void setPerfEstado(ProfileStatus perfEstado) { this.perfEstado = perfEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
