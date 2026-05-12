package development.v.development.infrastruture.entities;

import java.time.LocalDateTime;

import development.v.development.infrastruture.enums.DiningAreaStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "area_mesa")
@EntityListeners(AuditingEntityListener.class)
public class DiningAreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id")
    private Long areaId;

    @Column(name = "sede_id", nullable = false)
    private Long sedeId;

    @Column(name = "area_nombre", nullable = false, length = 100)
    private String areaNombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "area_estado", nullable = false)
    private DiningAreaStatus areaEstado;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getAreaId() { return areaId; }
    public void setAreaId(Long areaId) { this.areaId = areaId; }
    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public String getAreaNombre() { return areaNombre; }
    public void setAreaNombre(String areaNombre) { this.areaNombre = areaNombre; }
    public DiningAreaStatus getAreaEstado() { return areaEstado; }
    public void setAreaEstado(DiningAreaStatus areaEstado) { this.areaEstado = areaEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
