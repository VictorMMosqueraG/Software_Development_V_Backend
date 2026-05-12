package development.v.development.domain.models;

import java.time.LocalDateTime;

public class DiningTable {
    private Long mesaId;
    private Long sedeId;
    private Long areaId;
    private String mesaNumero;
    private Integer capacidad;
    private Integer xPos;
    private Integer yPos;
    private String estado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getMesaId() { return mesaId; }
    public void setMesaId(Long mesaId) { this.mesaId = mesaId; }
    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public Long getAreaId() { return areaId; }
    public void setAreaId(Long areaId) { this.areaId = areaId; }
    public String getMesaNumero() { return mesaNumero; }
    public void setMesaNumero(String mesaNumero) { this.mesaNumero = mesaNumero; }
    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }
    public Integer getXPos() { return xPos; }
    public void setXPos(Integer xPos) { this.xPos = xPos; }
    public Integer getYPos() { return yPos; }
    public void setYPos(Integer yPos) { this.yPos = yPos; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
