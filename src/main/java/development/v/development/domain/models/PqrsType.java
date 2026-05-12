package development.v.development.domain.models;

import java.time.LocalDateTime;

public class PqrsType {
    private Long tpqrsId;
    private String tpqrsDescripcion;
    private String tpqrsEstado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getTpqrsId() { return tpqrsId; }
    public void setTpqrsId(Long tpqrsId) { this.tpqrsId = tpqrsId; }
    public String getTpqrsDescripcion() { return tpqrsDescripcion; }
    public void setTpqrsDescripcion(String tpqrsDescripcion) { this.tpqrsDescripcion = tpqrsDescripcion; }
    public String getTpqrsEstado() { return tpqrsEstado; }
    public void setTpqrsEstado(String tpqrsEstado) { this.tpqrsEstado = tpqrsEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
