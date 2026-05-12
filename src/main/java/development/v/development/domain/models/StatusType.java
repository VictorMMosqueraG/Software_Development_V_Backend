package development.v.development.domain.models;

import java.time.LocalDateTime;

public class StatusType {
    private Long tesId;
    private String tesDescripcion;
    private String tesEstado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getTesId() { return tesId; }
    public void setTesId(Long tesId) { this.tesId = tesId; }
    public String getTesDescripcion() { return tesDescripcion; }
    public void setTesDescripcion(String tesDescripcion) { this.tesDescripcion = tesDescripcion; }
    public String getTesEstado() { return tesEstado; }
    public void setTesEstado(String tesEstado) { this.tesEstado = tesEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
