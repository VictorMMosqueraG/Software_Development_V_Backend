package development.v.development.domain.models;

import java.time.LocalDateTime;

import development.v.development.infrastruture.enums.ReservationStatus;

public class Reservation {
    private Long resId;
    private Long sedeId;
    private String resNombreCli;
    private String resTelefono;
    private LocalDateTime resFechaHora;
    private Integer resPersonas;
    private Long mesaId;
    private String resNota;
    private ReservationStatus resEstado;
    private LocalDateTime createdAt;
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
