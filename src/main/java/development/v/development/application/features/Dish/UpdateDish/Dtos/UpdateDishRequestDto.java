package development.v.development.application.features.Dish.UpdateDish.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;

public class UpdateDishRequestDto {

    @Schema(description = "Descripción del plato", example = "Bandeja Paisa")
    private String plaDescripcion;

    @Schema(description = "Precio del plato", example = "25000.0")
    private Float plaPrecio;

    @Schema(description = "ID del estado", example = "1")
    private Integer estId;

    public String getPlaDescripcion() { return plaDescripcion; }
    public void setPlaDescripcion(String plaDescripcion) { this.plaDescripcion = plaDescripcion; }

    public Float getPlaPrecio() { return plaPrecio; }
    public void setPlaPrecio(Float plaPrecio) { this.plaPrecio = plaPrecio; }

    public Integer getEstId() { return estId; }
    public void setEstId(Integer estId) { this.estId = estId; }
}

