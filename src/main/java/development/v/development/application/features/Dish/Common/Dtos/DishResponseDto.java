package development.v.development.application.features.Dish.Common.Dtos;

public class DishResponseDto {

    private Integer plaId;
    private String plaDescripcion;
    private Float plaPrecio;
    private Integer estId;
    private String plaImagen;

    public Integer getPlaId() { return plaId; }
    public void setPlaId(Integer plaId) { this.plaId = plaId; }

    public String getPlaDescripcion() { return plaDescripcion; }
    public void setPlaDescripcion(String plaDescripcion) { this.plaDescripcion = plaDescripcion; }

    public Float getPlaPrecio() { return plaPrecio; }
    public void setPlaPrecio(Float plaPrecio) { this.plaPrecio = plaPrecio; }

    public Integer getEstId() { return estId; }
    public void setEstId(Integer estId) { this.estId = estId; }

    public String getPlaImagen() { return plaImagen; }
    public void setPlaImagen(String plaImagen) { this.plaImagen = plaImagen; }
}

