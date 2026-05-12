package development.v.development.infrastruture.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "pqrs")
@EntityListeners(AuditingEntityListener.class)
public class PqrsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pqrs_id")
    private Long pqrsId;

    @Column(name = "pqrs_fecha", nullable = false)
    private LocalDate pqrsFecha;

    @Column(name = "pqrs_descripcion", nullable = false, columnDefinition = "TEXT")
    private String pqrsDescripcion;

    @Column(name = "pqrs_correo", nullable = false, length = 100)
    private String pqrsCorreo;

    @Column(name = "pqrs_telefono", nullable = false, length = 20)
    private String pqrsTelefono;

    @Column(name = "tpqrs_id", nullable = false)
    private Long tpqrsId;

    @Column(name = "est_id", nullable = false)
    private Long estId;

    @Column(name = "pqrs_respuesta", columnDefinition = "TEXT")
    private String pqrsRespuesta;

    @Column(name = "usu_id_responde")
    private Long usuIdResponde;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getPqrsId() { return pqrsId; }
    public void setPqrsId(Long pqrsId) { this.pqrsId = pqrsId; }
    public LocalDate getPqrsFecha() { return pqrsFecha; }
    public void setPqrsFecha(LocalDate pqrsFecha) { this.pqrsFecha = pqrsFecha; }
    public String getPqrsDescripcion() { return pqrsDescripcion; }
    public void setPqrsDescripcion(String pqrsDescripcion) { this.pqrsDescripcion = pqrsDescripcion; }
    public String getPqrsCorreo() { return pqrsCorreo; }
    public void setPqrsCorreo(String pqrsCorreo) { this.pqrsCorreo = pqrsCorreo; }
    public String getPqrsTelefono() { return pqrsTelefono; }
    public void setPqrsTelefono(String pqrsTelefono) { this.pqrsTelefono = pqrsTelefono; }
    public Long getTpqrsId() { return tpqrsId; }
    public void setTpqrsId(Long tpqrsId) { this.tpqrsId = tpqrsId; }
    public Long getEstId() { return estId; }
    public void setEstId(Long estId) { this.estId = estId; }
    public String getPqrsRespuesta() { return pqrsRespuesta; }
    public void setPqrsRespuesta(String pqrsRespuesta) { this.pqrsRespuesta = pqrsRespuesta; }
    public Long getUsuIdResponde() { return usuIdResponde; }
    public void setUsuIdResponde(Long usuIdResponde) { this.usuIdResponde = usuIdResponde; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
