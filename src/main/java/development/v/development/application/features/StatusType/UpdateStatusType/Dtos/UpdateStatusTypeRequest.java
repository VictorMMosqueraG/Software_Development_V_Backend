package development.v.development.application.features.StatusType.UpdateStatusType.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdateStatusTypeRequest {

    @NotBlank(message = "La descripcion es requerida")
    @Size(max = 50, message = "La descripcion no puede superar 50 caracteres")
    @Schema(description = "Descripcion del tipo de estado", example = "Estado de mesa")
    private String tesDescripcion;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "ACTIVO|INACTIVO", message = "El estado debe ser ACTIVO o INACTIVO")
    @Schema(description = "Estado del tipo de estado", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String tesEstado;

    public String getTesDescripcion() { return tesDescripcion; }
    public void setTesDescripcion(String tesDescripcion) { this.tesDescripcion = tesDescripcion; }
    public String getTesEstado() { return tesEstado; }
    public void setTesEstado(String tesEstado) { this.tesEstado = tesEstado; }
}
