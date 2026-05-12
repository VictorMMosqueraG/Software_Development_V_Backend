package development.v.development.application.features.SupplyCategory.UpdateSupplyCategory.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateSupplyCategoryRequest {

    @NotBlank(message = "El nombre es requerido")
    @Size(max = 100, message = "El nombre no puede superar 100 caracteres")
    @Schema(description = "Nombre de la categoria", example = "Lacteos")
    private String cinsNombre;

    @Size(max = 255, message = "La imagen no puede superar 255 caracteres")
    @Schema(description = "URL de la imagen", example = "https://example.com/image.png")
    private String cinsImagen;

    @NotNull(message = "El estado es requerido")
    @Schema(description = "Estado de la categoria (1=activo, 0=inactivo)", example = "1")
    private Integer cinsEstado;

    public String getCinsNombre() { return cinsNombre; }
    public void setCinsNombre(String cinsNombre) { this.cinsNombre = cinsNombre; }
    public String getCinsImagen() { return cinsImagen; }
    public void setCinsImagen(String cinsImagen) { this.cinsImagen = cinsImagen; }
    public Integer getCinsEstado() { return cinsEstado; }
    public void setCinsEstado(Integer cinsEstado) { this.cinsEstado = cinsEstado; }
}
