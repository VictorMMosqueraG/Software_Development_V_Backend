package development.v.development.application.features.Presentation.UpdatePresentation.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdatePresentationRequest {

    @NotBlank(message = "La descripcion es requerida")
    @Size(max = 50, message = "La descripcion no puede superar 50 caracteres")
    @Schema(description = "Descripcion de la presentacion", example = "Kilogramo")
    private String presDescripcion;

    @NotBlank(message = "La abreviatura es requerida")
    @Size(max = 10, message = "La abreviatura no puede superar 10 caracteres")
    @Schema(description = "Abreviatura de la presentacion", example = "Kg")
    private String presAbreviatura;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "ACTIVO|INACTIVO", message = "El estado debe ser ACTIVO o INACTIVO")
    @Schema(description = "Estado de la presentacion", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String presEstado;

    public String getPresDescripcion() { return presDescripcion; }
    public void setPresDescripcion(String presDescripcion) { this.presDescripcion = presDescripcion; }
    public String getPresAbreviatura() { return presAbreviatura; }
    public void setPresAbreviatura(String presAbreviatura) { this.presAbreviatura = presAbreviatura; }
    public String getPresEstado() { return presEstado; }
    public void setPresEstado(String presEstado) { this.presEstado = presEstado; }
}
