package development.v.development.infrastruture.entities;

import java.time.LocalDateTime;

import development.v.development.infrastruture.enums.PaymentMethodStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "forma_pago")
@EntityListeners(AuditingEntityListener.class)
public class PaymentMethodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fp_id")
    private Long fpId;

    @Column(name = "fp_descripcion", nullable = false, length = 60)
    private String fpDescripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "fp_estado", nullable = false)
    private PaymentMethodStatus fpEstado;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getFpId() { return fpId; }
    public void setFpId(Long fpId) { this.fpId = fpId; }
    public String getFpDescripcion() { return fpDescripcion; }
    public void setFpDescripcion(String fpDescripcion) { this.fpDescripcion = fpDescripcion; }
    public PaymentMethodStatus getFpEstado() { return fpEstado; }
    public void setFpEstado(PaymentMethodStatus fpEstado) { this.fpEstado = fpEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
