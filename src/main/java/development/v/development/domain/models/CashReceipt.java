package development.v.development.domain.models;

import java.time.LocalDate;

public class CashReceipt {
    private Integer rcNum;
    private Long usuId;
    private LocalDate rcFecha;
    private Long pedId;
    private Long     cliId;
    private Double rcTotal;
    private String rcObservacion;
    private String rcEstado;

    public Integer getRcNum() { return rcNum; }
    public void setRcNum(Integer rcNum) { this.rcNum = rcNum; }

    public Long getUsuId() { return usuId; }
    public void setUsuId(Long usuId) { this.usuId = usuId; }

    public LocalDate getRcFecha() { return rcFecha; }
    public void setRcFecha(LocalDate rcFecha) { this.rcFecha = rcFecha; }

    public Long getPedId() { return pedId; }
    public void setPedId(Long pedId) { this.pedId = pedId; }

    public Long getCliId() { return cliId; }
    public void setCliId(Long cliId) { this.cliId = cliId; }

    public Double getRcTotal() { return rcTotal; }
    public void setRcTotal(Double rcTotal) { this.rcTotal = rcTotal; }

    public String getRcObservacion() { return rcObservacion; }
    public void setRcObservacion(String rcObservacion) { this.rcObservacion = rcObservacion; }

    public String getRcEstado() { return rcEstado; }
    public void setRcEstado(String rcEstado) { this.rcEstado = rcEstado; }
}