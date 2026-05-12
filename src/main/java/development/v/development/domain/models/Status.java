package development.v.development.domain.models;

import java.time.LocalDateTime;

public class Status {
    private Long estId;
    private String estDescripcion;
    private Long tesId;
    private String estEstado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getEstId() { return estId; }
    public void setEstId(Long estId) { this.estId = estId; }
    public String getEstDescripcion() { return estDescripcion; }
    public void setEstDescripcion(String estDescripcion) { this.estDescripcion = estDescripcion; }
    public Long getTesId() { return tesId; }
    public void setTesId(Long tesId) { this.tesId = tesId; }
    public String getEstEstado() { return estEstado; }
    public void setEstEstado(String estEstado) { this.estEstado = estEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
