package development.v.development.domain.models;

import java.time.LocalDateTime;

public class DishCategory {
    private Long catId;
    private String catNombre;
    private String catImagen;
    private Integer catEstado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getCatId() { return catId; }
    public void setCatId(Long catId) { this.catId = catId; }
    public String getCatNombre() { return catNombre; }
    public void setCatNombre(String catNombre) { this.catNombre = catNombre; }
    public String getCatImagen() { return catImagen; }
    public void setCatImagen(String catImagen) { this.catImagen = catImagen; }
    public Integer getCatEstado() { return catEstado; }
    public void setCatEstado(Integer catEstado) { this.catEstado = catEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
