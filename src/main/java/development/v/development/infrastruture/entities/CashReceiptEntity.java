package development.v.development.infrastruture.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import development.v.development.infrastruture.enums.CashReceiptStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "recibo_caja")
@EntityListeners(AuditingEntityListener.class)
public class CashReceiptEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rc_num")
    private Long rcNum;

    @Column(name = "sede_id", nullable = false)
    private Long sedeId;

    @Column(name = "usu_id", nullable = false)
    private Long usuId;

    @Column(name = "rc_fecha", nullable = false)
    private LocalDate rcFecha;

    @Column(name = "ped_id", nullable = false)
    private Long pedId;

    @Column(name = "cli_id")
    private Long cliId;

    @Column(name = "fp_id", nullable = false)
    private Long fpId;

    @Column(name = "rc_subtotal", nullable = false, precision = 14, scale = 2)
    private BigDecimal rcSubtotal;

    @Column(name = "rc_descuento", nullable = false, precision = 14, scale = 2)
    private BigDecimal rcDescuento;

    @Column(name = "rc_propina", nullable = false, precision = 14, scale = 2)
    private BigDecimal rcPropina;

    @Column(name = "rc_total", nullable = false, precision = 14, scale = 2)
    private BigDecimal rcTotal;

    @Column(name = "rc_monto_rec", precision = 14, scale = 2)
    private BigDecimal rcMontoRec;

    @Column(name = "rc_cambio", nullable = false, precision = 14, scale = 2)
    private BigDecimal rcCambio;

    @Column(name = "rc_observacion", length = 360)
    private String rcObservacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "rc_estado", nullable = false)
    private CashReceiptStatus rcEstado;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getRcNum() { return rcNum; }
    public void setRcNum(Long rcNum) { this.rcNum = rcNum; }

    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }

    public Long getUsuId() { return usuId; }
    public void setUsuId(Long usuId) { this.usuId = usuId; }

    public LocalDate getRcFecha() { return rcFecha; }
    public void setRcFecha(LocalDate rcFecha) { this.rcFecha = rcFecha; }

    public Long getPedId() { return pedId; }
    public void setPedId(Long pedId) { this.pedId = pedId; }

    public Long getCliId() { return cliId; }
    public void setCliId(Long cliId) { this.cliId = cliId; }

    public Long getFpId() { return fpId; }
    public void setFpId(Long fpId) { this.fpId = fpId; }

    public BigDecimal getRcSubtotal() { return rcSubtotal; }
    public void setRcSubtotal(BigDecimal rcSubtotal) { this.rcSubtotal = rcSubtotal; }

    public BigDecimal getRcDescuento() { return rcDescuento; }
    public void setRcDescuento(BigDecimal rcDescuento) { this.rcDescuento = rcDescuento; }

    public BigDecimal getRcPropina() { return rcPropina; }
    public void setRcPropina(BigDecimal rcPropina) { this.rcPropina = rcPropina; }

    public BigDecimal getRcTotal() { return rcTotal; }
    public void setRcTotal(BigDecimal rcTotal) { this.rcTotal = rcTotal; }

    public BigDecimal getRcMontoRec() { return rcMontoRec; }
    public void setRcMontoRec(BigDecimal rcMontoRec) { this.rcMontoRec = rcMontoRec; }

    public BigDecimal getRcCambio() { return rcCambio; }
    public void setRcCambio(BigDecimal rcCambio) { this.rcCambio = rcCambio; }

    public String getRcObservacion() { return rcObservacion; }
    public void setRcObservacion(String rcObservacion) { this.rcObservacion = rcObservacion; }

    public CashReceiptStatus getRcEstado() { return rcEstado; }
    public void setRcEstado(CashReceiptStatus rcEstado) { this.rcEstado = rcEstado; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
