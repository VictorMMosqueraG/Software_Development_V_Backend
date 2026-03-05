package development.v.development.infrastruture.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "recibo_caja")
public class CashReceiptEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rc_num")
    private Integer rcNum;

    @Column(name = "usu_id", nullable = false)
    private Integer usuId;

    @Column(name = "rc_fecha", nullable = false)
    private LocalDate rcFecha;

    @Column(name = "ped_id", nullable = false)
    private Integer pedId;

    @Column(name = "cli_id", nullable = false)
    private Integer cliId;

    @Column(name = "rc_total", nullable = false)
    private Double rcTotal;

    @Column(name = "rc_observacion", nullable = false, length = 360)
    private String rcObservacion;

    @Column(name = "rc_estado", nullable = false, length = 10)
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
