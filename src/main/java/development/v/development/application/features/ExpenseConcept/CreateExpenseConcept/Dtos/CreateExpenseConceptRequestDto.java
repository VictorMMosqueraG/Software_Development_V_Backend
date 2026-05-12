package development.v.development.application.features.ExpenseConcept.CreateExpenseConcept.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(description = "Request para crear un concepto de egreso")
public class CreateExpenseConceptRequestDto {

    @NotBlank(message = "La descripcion es requerida")
    @Size(max = 120, message = "La descripcion no puede superar 120 caracteres")
    @Schema(description = "Descripcion del concepto de egreso", example = "Compra de insumos")
    private String conDescripcion;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "ACTIVO|INACTIVO", message = "El estado debe ser ACTIVO o INACTIVO")
    @Schema(description = "Estado del concepto de egreso", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String conEstado;

    public String getConDescripcion() { return conDescripcion; }
    public void setConDescripcion(String conDescripcion) { this.conDescripcion = conDescripcion; }
    public String getConEstado() { return conEstado; }
    public void setConEstado(String conEstado) { this.conEstado = conEstado; }
}
