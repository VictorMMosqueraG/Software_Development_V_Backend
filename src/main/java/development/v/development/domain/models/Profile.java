package development.v.development.domain.models;

import java.time.LocalDateTime;

public class Profile {
    private Long perfId;
    private String perfDescripcion;
    private String perfEstado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getPerfId() { return perfId; }
    public void setPerfId(Long perfId) { this.perfId = perfId; }
    public String getPerfDescripcion() { return perfDescripcion; }
    public void setPerfDescripcion(String perfDescripcion) { this.perfDescripcion = perfDescripcion; }
    public String getPerfEstado() { return perfEstado; }
    public void setPerfEstado(String perfEstado) { this.perfEstado = perfEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
