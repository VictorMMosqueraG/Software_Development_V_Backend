package development.v.development.domain.models;

import java.time.LocalDateTime;

public class SupplyCategory {
    private Long cinsId;
    private String cinsNombre;
    private String cinsImagen;
    private Integer cinsEstado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getCinsId() { return cinsId; }
    public void setCinsId(Long cinsId) { this.cinsId = cinsId; }
    public String getCinsNombre() { return cinsNombre; }
    public void setCinsNombre(String cinsNombre) { this.cinsNombre = cinsNombre; }
    public String getCinsImagen() { return cinsImagen; }
    public void setCinsImagen(String cinsImagen) { this.cinsImagen = cinsImagen; }
    public Integer getCinsEstado() { return cinsEstado; }
    public void setCinsEstado(Integer cinsEstado) { this.cinsEstado = cinsEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
