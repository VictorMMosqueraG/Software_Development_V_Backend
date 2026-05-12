package development.v.development.domain.models;

import java.time.LocalDateTime;

public class Branch {
    private Long sedeId;
    private String sedeNombre;
    private String sedeDireccion;
    private String sedeTelefono;
    private String sedeEstado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public String getSedeNombre() { return sedeNombre; }
    public void setSedeNombre(String sedeNombre) { this.sedeNombre = sedeNombre; }
    public String getSedeDireccion() { return sedeDireccion; }
    public void setSedeDireccion(String sedeDireccion) { this.sedeDireccion = sedeDireccion; }
    public String getSedeTelefono() { return sedeTelefono; }
    public void setSedeTelefono(String sedeTelefono) { this.sedeTelefono = sedeTelefono; }
    public String getSedeEstado() { return sedeEstado; }
    public void setSedeEstado(String sedeEstado) { this.sedeEstado = sedeEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
