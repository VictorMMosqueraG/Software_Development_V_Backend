package development.v.development.application.features.Status.CreateStatus.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(description = "Request para crear un estado")
public class CreateStatusRequestDto {

    @NotBlank(message = "La descripcion es requerida")
    @Size(max = 60, message = "La descripcion no puede superar 60 caracteres")
    @Schema(description = "Descripcion del estado", example = "Pendiente")
    private String estDescripcion;

    @NotNull(message = "El tipo de estado es requerido")
    @Schema(description = "ID del tipo de estado", example = "1")
    private Long tesId;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "ACTIVO|INACTIVO", message = "El estado debe ser ACTIVO o INACTIVO")
    @Schema(description = "Estado del estado", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String estEstado;

    public String getEstDescripcion() { return estDescripcion; }
    public void setEstDescripcion(String estDescripcion) { this.estDescripcion = estDescripcion; }
    public Long getTesId() { return tesId; }
    public void setTesId(Long tesId) { this.tesId = tesId; }
    public String getEstEstado() { return estEstado; }
    public void setEstEstado(String estEstado) { this.estEstado = estEstado; }
}
