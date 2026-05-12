package development.v.development.infrastruture.entities;

import java.time.LocalDateTime;

import development.v.development.infrastruture.enums.ExpenseConceptStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "concepto_egreso")
@EntityListeners(AuditingEntityListener.class)
public class ExpenseConceptEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "con_id")
    private Long conId;

    @Column(name = "con_descripcion", nullable = false, length = 120)
    private String conDescripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "con_estado", nullable = false)
    private ExpenseConceptStatus conEstado;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getConId() { return conId; }
    public void setConId(Long conId) { this.conId = conId; }
    public String getConDescripcion() { return conDescripcion; }
    public void setConDescripcion(String conDescripcion) { this.conDescripcion = conDescripcion; }
    public ExpenseConceptStatus getConEstado() { return conEstado; }
    public void setConEstado(ExpenseConceptStatus conEstado) { this.conEstado = conEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
