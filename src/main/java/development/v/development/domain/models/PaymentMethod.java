package development.v.development.domain.models;

import java.time.LocalDateTime;

public class PaymentMethod {
    private Long fpId;
    private String fpDescripcion;
    private String fpEstado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getFpId() { return fpId; }
    public void setFpId(Long fpId) { this.fpId = fpId; }
    public String getFpDescripcion() { return fpDescripcion; }
    public void setFpDescripcion(String fpDescripcion) { this.fpDescripcion = fpDescripcion; }
    public String getFpEstado() { return fpEstado; }
    public void setFpEstado(String fpEstado) { this.fpEstado = fpEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
