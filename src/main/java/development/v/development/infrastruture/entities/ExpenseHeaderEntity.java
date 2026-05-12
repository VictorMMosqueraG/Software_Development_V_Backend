package development.v.development.infrastruture.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import development.v.development.infrastruture.enums.ExpenseHeaderStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "encabezado_egresos")
@EntityListeners(AuditingEntityListener.class)
public class ExpenseHeaderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "egr_id")
    private Long egrId;

    @Column(name = "sede_id", nullable = false)
    private Long sedeId;

    @Column(name = "no_egreso", nullable = false, unique = true)
    private Long noEgreso;

    @Column(name = "fecha_documento", nullable = false)
    private LocalDate fechaDocumento;

    @Column(name = "tercero_identificacion", nullable = false, length = 20)
    private String terceroIdentificacion;

    @Column(name = "tercero_nombre", length = 150)
    private String terceroNombre;

    @Column(name = "detalle", nullable = false, length = 250)
    private String detalle;

    @Column(name = "fp_id", nullable = false)
    private Long fpId;

    @Column(name = "con_id", nullable = false)
    private Long conId;

    @Column(name = "no_documento", nullable = false, length = 30)
    private String noDocumento;

    @Column(name = "valor_egreso", nullable = false, precision = 14, scale = 2)
    private BigDecimal valorEgreso;

    @Column(name = "usu_id", nullable = false)
    private Long usuId;

    @Enumerated(EnumType.STRING)
    @Column(name = "egr_estado", nullable = false)
    private ExpenseHeaderStatus egrEstado;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getEgrId() { return egrId; }
    public void setEgrId(Long egrId) { this.egrId = egrId; }
    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public Long getNoEgreso() { return noEgreso; }
    public void setNoEgreso(Long noEgreso) { this.noEgreso = noEgreso; }
    public LocalDate getFechaDocumento() { return fechaDocumento; }
    public void setFechaDocumento(LocalDate fechaDocumento) { this.fechaDocumento = fechaDocumento; }
    public String getTerceroIdentificacion() { return terceroIdentificacion; }
    public void setTerceroIdentificacion(String terceroIdentificacion) { this.terceroIdentificacion = terceroIdentificacion; }
    public String getTerceroNombre() { return terceroNombre; }
    public void setTerceroNombre(String terceroNombre) { this.terceroNombre = terceroNombre; }
    public String getDetalle() { return detalle; }
    public void setDetalle(String detalle) { this.detalle = detalle; }
    public Long getFpId() { return fpId; }
    public void setFpId(Long fpId) { this.fpId = fpId; }
    public Long getConId() { return conId; }
    public void setConId(Long conId) { this.conId = conId; }
    public String getNoDocumento() { return noDocumento; }
    public void setNoDocumento(String noDocumento) { this.noDocumento = noDocumento; }
    public BigDecimal getValorEgreso() { return valorEgreso; }
    public void setValorEgreso(BigDecimal valorEgreso) { this.valorEgreso = valorEgreso; }
    public Long getUsuId() { return usuId; }
    public void setUsuId(Long usuId) { this.usuId = usuId; }
    public ExpenseHeaderStatus getEgrEstado() { return egrEstado; }
    public void setEgrEstado(ExpenseHeaderStatus egrEstado) { this.egrEstado = egrEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
