package development.v.development.infrastruture.entities;

import java.time.LocalDateTime;

import development.v.development.infrastruture.enums.ReservationStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "reservacion")
@EntityListeners(AuditingEntityListener.class)
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "res_id")
    private Long resId;

    @Column(name = "sede_id", nullable = false)
    private Long sedeId;

    @Column(name = "res_nombre_cli", nullable = false, length = 100)
    private String resNombreCli;

    @Column(name = "res_telefono", length = 20)
    private String resTelefono;

    @Column(name = "res_fecha_hora", nullable = false)
    private LocalDateTime resFechaHora;

    @Column(name = "res_personas", nullable = false)
    private Integer resPersonas;

    @Column(name = "mesa_id")
    private Long mesaId;

    @Column(name = "res_nota", columnDefinition = "TEXT")
    private String resNota;

    @Enumerated(EnumType.STRING)
    @Column(name = "res_estado", nullable = false)
    private ReservationStatus resEstado;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getResId() { return resId; }
    public void setResId(Long resId) { this.resId = resId; }
    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public String getResNombreCli() { return resNombreCli; }
    public void setResNombreCli(String resNombreCli) { this.resNombreCli = resNombreCli; }
    public String getResTelefono() { return resTelefono; }
    public void setResTelefono(String resTelefono) { this.resTelefono = resTelefono; }
    public LocalDateTime getResFechaHora() { return resFechaHora; }
    public void setResFechaHora(LocalDateTime resFechaHora) { this.resFechaHora = resFechaHora; }
    public Integer getResPersonas() { return resPersonas; }
    public void setResPersonas(Integer resPersonas) { this.resPersonas = resPersonas; }
    public Long getMesaId() { return mesaId; }
    public void setMesaId(Long mesaId) { this.mesaId = mesaId; }
    public String getResNota() { return resNota; }
    public void setResNota(String resNota) { this.resNota = resNota; }
    public ReservationStatus getResEstado() { return resEstado; }
    public void setResEstado(ReservationStatus resEstado) { this.resEstado = resEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
