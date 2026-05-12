package development.v.development.domain.models;

import java.time.LocalDateTime;

public class DiningArea {
    private Long areaId;
    private Long sedeId;
    private String areaNombre;
    private String areaEstado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getAreaId() { return areaId; }
    public void setAreaId(Long areaId) { this.areaId = areaId; }
    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public String getAreaNombre() { return areaNombre; }
    public void setAreaNombre(String areaNombre) { this.areaNombre = areaNombre; }
    public String getAreaEstado() { return areaEstado; }
    public void setAreaEstado(String areaEstado) { this.areaEstado = areaEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
