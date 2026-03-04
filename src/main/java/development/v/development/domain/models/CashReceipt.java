package development.v.development.domain.models;

import java.time.LocalDate;

public class CashReceipt {
    private Integer rcNum;
    private Integer usuId;
    private LocalDate rcFecha;
    private Integer pedId;
    private Integer cliId;
    private Double rcTotal;
    private String rcObservacion;
    private String rcEstado;

    public Integer getRcNum() { return rcNum; }
    public void setRcNum(Integer rcNum) { this.rcNum = rcNum; }

    public Integer getUsuId() { return usuId; }
    public void setUsuId(Integer usuId) { this.usuId = usuId; }

    public LocalDate getRcFecha() { return rcFecha; }
    public void setRcFecha(LocalDate rcFecha) { this.rcFecha = rcFecha; }

    public Integer getPedId() { return pedId; }
    public void setPedId(Integer pedId) { this.pedId = pedId; }

    public Integer getCliId() { return cliId; }
    public void setCliId(Integer cliId) { this.cliId = cliId; }

    public Double getRcTotal() { return rcTotal; }
    public void setRcTotal(Double rcTotal) { this.rcTotal = rcTotal; }

    public String getRcObservacion() { return rcObservacion; }
    public void setRcObservacion(String rcObservacion) { this.rcObservacion = rcObservacion; }

    public String getRcEstado() { return rcEstado; }
    public void setRcEstado(String rcEstado) { this.rcEstado = rcEstado; }
}