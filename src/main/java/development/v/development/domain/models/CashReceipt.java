package development.v.development.domain.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CashReceipt {
    private Long rcNum;
    private Long sedeId;
    private Long usuId;
    private LocalDate rcFecha;
    private Long pedId;
    private Long cliId;
    private Long fpId;
    private BigDecimal rcSubtotal;
    private BigDecimal rcDescuento;
    private BigDecimal rcPropina;
    private BigDecimal rcTotal;
    private BigDecimal rcMontoRec;
    private BigDecimal rcCambio;
    private String rcObservacion;
    private String rcEstado;
    private LocalDateTime createdAt;
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

    public String getRcEstado() { return rcEstado; }
    public void setRcEstado(String rcEstado) { this.rcEstado = rcEstado; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
