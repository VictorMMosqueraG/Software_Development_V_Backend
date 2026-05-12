package development.v.development.domain.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pqrs {
    private Long pqrsId;
    private LocalDate pqrsFecha;
    private String pqrsDescripcion;
    private String pqrsCorreo;
    private String pqrsTelefono;
    private Long tpqrsId;
    private Long estId;
    private String pqrsRespuesta;
    private Long usuIdResponde;
    private LocalDateTime createdAt;
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
