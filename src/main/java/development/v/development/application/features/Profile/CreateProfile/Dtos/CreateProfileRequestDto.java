package development.v.development.application.features.Profile.CreateProfile.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(description = "Request para crear un perfil")
public class CreateProfileRequestDto {

    @NotBlank(message = "La descripción es requerida")
    @Size(max = 60, message = "La descripción no puede superar 60 caracteres")
    @Schema(description = "Descripción del perfil", example = "Administrador")
    private String perfDescripcion;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "ACTIVO|INACTIVO", message = "El estado debe ser ACTIVO o INACTIVO")
    @Schema(description = "Estado del perfil", example = "ACTIVO", allowableValues = {"ACTIVO","INACTIVO"})
    private String perfEstado;

    public String getPerfDescripcion() { return perfDescripcion; }
    public void setPerfDescripcion(String perfDescripcion) { this.perfDescripcion = perfDescripcion; }
    public String getPerfEstado() { return perfEstado; }
    public void setPerfEstado(String perfEstado) { this.perfEstado = perfEstado; }
}
