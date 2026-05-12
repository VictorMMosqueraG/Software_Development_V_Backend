package development.v.development.domain.models;

import java.time.LocalDateTime;

public class ExpenseConcept {
    private Long conId;
    private String conDescripcion;
    private String conEstado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getConId() { return conId; }
    public void setConId(Long conId) { this.conId = conId; }
    public String getConDescripcion() { return conDescripcion; }
    public void setConDescripcion(String conDescripcion) { this.conDescripcion = conDescripcion; }
    public String getConEstado() { return conEstado; }
    public void setConEstado(String conEstado) { this.conEstado = conEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
