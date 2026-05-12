package development.v.development.infrastruture.entities;

import java.time.LocalDateTime;

import development.v.development.infrastruture.enums.PresentationStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "presentacion")
@EntityListeners(AuditingEntityListener.class)
public class PresentationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pres_id")
    private Long presId;

    @Column(name = "pres_descripcion", nullable = false, length = 50)
    private String presDescripcion;

    @Column(name = "pres_abreviatura", nullable = false, length = 10)
    private String presAbreviatura;

    @Enumerated(EnumType.STRING)
    @Column(name = "pres_estado", nullable = false)
    private PresentationStatus presEstado;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getPresId() { return presId; }
    public void setPresId(Long presId) { this.presId = presId; }
    public String getPresDescripcion() { return presDescripcion; }
    public void setPresDescripcion(String presDescripcion) { this.presDescripcion = presDescripcion; }
    public String getPresAbreviatura() { return presAbreviatura; }
    public void setPresAbreviatura(String presAbreviatura) { this.presAbreviatura = presAbreviatura; }
    public PresentationStatus getPresEstado() { return presEstado; }
    public void setPresEstado(PresentationStatus presEstado) { this.presEstado = presEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
