package development.v.development.infrastruture.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "pedido_detalle")
@EntityListeners(AuditingEntityListener.class)
public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ped_det_id")
    private Long pedDetId;

    @Column(name = "ped_id", nullable = false)
    private Long pedId;

    @Column(name = "pla_id", nullable = false)
    private Long plaId;

    @Column(name = "ped_det_cant", nullable = false)
    private Integer pedDetCant;

    @Column(name = "ped_det_precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal pedDetPrecio;

    @Column(name = "ped_det_obser", length = 255)
    private String pedDetObser;

    @Column(name = "est_id", nullable = false)
    private Long estId;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getPedDetId() { return pedDetId; }
    public void setPedDetId(Long pedDetId) { this.pedDetId = pedDetId; }
    public Long getPedId() { return pedId; }
    public void setPedId(Long pedId) { this.pedId = pedId; }
    public Long getPlaId() { return plaId; }
    public void setPlaId(Long plaId) { this.plaId = plaId; }
    public Integer getPedDetCant() { return pedDetCant; }
    public void setPedDetCant(Integer pedDetCant) { this.pedDetCant = pedDetCant; }
    public BigDecimal getPedDetPrecio() { return pedDetPrecio; }
    public void setPedDetPrecio(BigDecimal pedDetPrecio) { this.pedDetPrecio = pedDetPrecio; }
    public String getPedDetObser() { return pedDetObser; }
    public void setPedDetObser(String pedDetObser) { this.pedDetObser = pedDetObser; }
    public Long getEstId() { return estId; }
    public void setEstId(Long estId) { this.estId = estId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
