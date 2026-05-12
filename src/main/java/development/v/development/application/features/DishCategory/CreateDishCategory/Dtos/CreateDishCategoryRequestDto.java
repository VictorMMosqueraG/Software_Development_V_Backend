package development.v.development.application.features.DishCategory.CreateDishCategory.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Request para crear una categoria de plato")
public class CreateDishCategoryRequestDto {

    @NotBlank(message = "El nombre de la categoria es requerido")
    @Size(max = 100, message = "El nombre no puede superar 100 caracteres")
    @Schema(description = "Nombre de la categoria", example = "Entradas")
    private String catNombre;

    @Size(max = 255, message = "La imagen no puede superar 255 caracteres")
    @Schema(description = "URL de la imagen de la categoria", example = "https://example.com/img.png")
    private String catImagen;

    @NotNull(message = "El estado es requerido")
    @Schema(description = "Estado de la categoria (1=Activo, 0=Inactivo)", example = "1", allowableValues = {"0", "1"})
    private Integer catEstado;

    public String getCatNombre() { return catNombre; }
    public void setCatNombre(String catNombre) { this.catNombre = catNombre; }
    public String getCatImagen() { return catImagen; }
    public void setCatImagen(String catImagen) { this.catImagen = catImagen; }
    public Integer getCatEstado() { return catEstado; }
    public void setCatEstado(Integer catEstado) { this.catEstado = catEstado; }
}
