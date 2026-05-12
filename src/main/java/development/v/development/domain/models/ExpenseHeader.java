package development.v.development.domain.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExpenseHeader {
    private Long egrId;
    private Long sedeId;
    private Long noEgreso;
    private LocalDate fechaDocumento;
    private String terceroIdentificacion;
    private String terceroNombre;
    private String detalle;
    private Long fpId;
    private Long conId;
    private String noDocumento;
    private BigDecimal valorEgreso;
    private Long usuId;
    private String egrEstado;
    private LocalDateTime createdAt;
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
    public String getEgrEstado() { return egrEstado; }
    public void setEgrEstado(String egrEstado) { this.egrEstado = egrEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
