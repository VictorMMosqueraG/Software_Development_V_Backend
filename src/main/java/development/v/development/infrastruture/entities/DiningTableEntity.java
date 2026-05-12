package development.v.development.infrastruture.entities;

import java.time.LocalDateTime;

import development.v.development.infrastruture.enums.DiningTableStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "mesa")
@EntityListeners(AuditingEntityListener.class)
public class DiningTableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mesa_id")
    private Long mesaId;

    @Column(name = "sede_id", nullable = false)
    private Long sedeId;

    @Column(name = "area_id")
    private Long areaId;

    @Column(name = "mesa_numero", nullable = false, length = 10)
    private String mesaNumero;

    @Column(name = "capacidad", nullable = false)
    private Integer capacidad;

    @Column(name = "x_pos", nullable = false)
    private Integer xPos;

    @Column(name = "y_pos", nullable = false)
    private Integer yPos;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private DiningTableStatus estado;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getMesaId() { return mesaId; }
    public void setMesaId(Long mesaId) { this.mesaId = mesaId; }
    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public Long getAreaId() { return areaId; }
    public void setAreaId(Long areaId) { this.areaId = areaId; }
    public String getMesaNumero() { return mesaNumero; }
    public void setMesaNumero(String mesaNumero) { this.mesaNumero = mesaNumero; }
    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }
    public Integer getXPos() { return xPos; }
    public void setXPos(Integer xPos) { this.xPos = xPos; }
    public Integer getYPos() { return yPos; }
    public void setYPos(Integer yPos) { this.yPos = yPos; }
    public DiningTableStatus getEstado() { return estado; }
    public void setEstado(DiningTableStatus estado) { this.estado = estado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
