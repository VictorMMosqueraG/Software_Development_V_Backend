package development.v.development.application.features.Dish.CreateDish.Dtos;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Request para crear un plato")
public class CreateDishRequestDto {

    @NotNull(message = "La categoría es requerida")
    @Schema(description = "ID de la categoría", example = "1")
    private Long catId;

    @NotNull(message = "La descripción es requerida")
    @Size(max = 150, message = "La descripción no puede superar 150 caracteres")
    @Schema(description = "Descripción del plato", example = "Hamburguesa clásica")
    private String plaDescripcion;

    @Size(max = 20, message = "El código no puede superar 20 caracteres")
    @Schema(description = "Código del plato", example = "PLA-001")
    private String plaCodigo;

    @NotNull(message = "El precio es requerido")
    @Schema(description = "Precio del plato", example = "15.50")
    private BigDecimal plaPrecio;

    @Schema(description = "Costo del plato", example = "8.00")
    private BigDecimal plaCosto;

    @Size(max = 255, message = "La imagen no puede superar 255 caracteres")
    @Schema(description = "URL de la imagen del plato", example = "https://example.com/image.jpg")
    private String plaImagen;

    @NotNull(message = "El estado es requerido")
    @Schema(description = "ID del estado", example = "1")
    private Long estId;

    public Long getCatId() { return catId; }
    public void setCatId(Long catId) { this.catId = catId; }
    public String getPlaDescripcion() { return plaDescripcion; }
    public void setPlaDescripcion(String plaDescripcion) { this.plaDescripcion = plaDescripcion; }
    public String getPlaCodigo() { return plaCodigo; }
    public void setPlaCodigo(String plaCodigo) { this.plaCodigo = plaCodigo; }
    public BigDecimal getPlaPrecio() { return plaPrecio; }
    public void setPlaPrecio(BigDecimal plaPrecio) { this.plaPrecio = plaPrecio; }
    public BigDecimal getPlaCosto() { return plaCosto; }
    public void setPlaCosto(BigDecimal plaCosto) { this.plaCosto = plaCosto; }
    public String getPlaImagen() { return plaImagen; }
    public void setPlaImagen(String plaImagen) { this.plaImagen = plaImagen; }
    public Long getEstId() { return estId; }
    public void setEstId(Long estId) { this.estId = estId; }
}
