package development.v.development.infrastruture.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "pedido")
@EntityListeners(AuditingEntityListener.class)
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ped_id")
    private Long pedId;

    @Column(name = "sede_id", nullable = false)
    private Long sedeId;

    @Column(name = "ped_fecha", nullable = false)
    private LocalDate pedFecha;

    @Column(name = "usu_id", nullable = false)
    private Long usuId;

    @Column(name = "mesa_id", nullable = false)
    private Long mesaId;

    @Column(name = "est_id", nullable = false)
    private Long estId;

    @Column(name = "ped_obs", length = 360)
    private String pedObs;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getPedId() { return pedId; }
    public void setPedId(Long pedId) { this.pedId = pedId; }
    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public LocalDate getPedFecha() { return pedFecha; }
    public void setPedFecha(LocalDate pedFecha) { this.pedFecha = pedFecha; }
    public Long getUsuId() { return usuId; }
    public void setUsuId(Long usuId) { this.usuId = usuId; }
    public Long getMesaId() { return mesaId; }
    public void setMesaId(Long mesaId) { this.mesaId = mesaId; }
    public Long getEstId() { return estId; }
    public void setEstId(Long estId) { this.estId = estId; }
    public String getPedObs() { return pedObs; }
    public void setPedObs(String pedObs) { this.pedObs = pedObs; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
