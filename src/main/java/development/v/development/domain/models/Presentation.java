package development.v.development.domain.models;

import java.time.LocalDateTime;

public class Presentation {
    private Long presId;
    private String presDescripcion;
    private String presAbreviatura;
    private String presEstado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getPresId() { return presId; }
    public void setPresId(Long presId) { this.presId = presId; }
    public String getPresDescripcion() { return presDescripcion; }
    public void setPresDescripcion(String presDescripcion) { this.presDescripcion = presDescripcion; }
    public String getPresAbreviatura() { return presAbreviatura; }
    public void setPresAbreviatura(String presAbreviatura) { this.presAbreviatura = presAbreviatura; }
    public String getPresEstado() { return presEstado; }
    public void setPresEstado(String presEstado) { this.presEstado = presEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
