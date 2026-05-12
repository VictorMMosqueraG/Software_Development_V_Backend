package development.v.development.application.features.PqrsType.UpdatePqrsType.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdatePqrsTypeRequest {

    @NotBlank(message = "La descripcion es requerida")
    @Size(max = 60, message = "La descripcion no puede superar 60 caracteres")
    @Schema(description = "Descripcion del tipo de PQRS", example = "Peticion")
    private String tpqrsDescripcion;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "ACTIVO|INACTIVO", message = "El estado debe ser ACTIVO o INACTIVO")
    @Schema(description = "Estado del tipo de PQRS", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String tpqrsEstado;

    public String getTpqrsDescripcion() { return tpqrsDescripcion; }
    public void setTpqrsDescripcion(String tpqrsDescripcion) { this.tpqrsDescripcion = tpqrsDescripcion; }
    public String getTpqrsEstado() { return tpqrsEstado; }
    public void setTpqrsEstado(String tpqrsEstado) { this.tpqrsEstado = tpqrsEstado; }
}
