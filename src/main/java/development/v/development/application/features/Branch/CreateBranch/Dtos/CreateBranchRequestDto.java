package development.v.development.application.features.Branch.CreateBranch.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(description = "Request para crear una sede")
public class CreateBranchRequestDto {

    @NotBlank(message = "El nombre es requerido")
    @Size(max = 120, message = "El nombre no puede superar 120 caracteres")
    @Schema(description = "Nombre de la sede", example = "Sede Principal")
    private String sedeNombre;

    @Size(max = 200, message = "La dirección no puede superar 200 caracteres")
    @Schema(description = "Dirección de la sede", example = "Calle 10 # 5-20")
    private String sedeDireccion;

    @Size(max = 30, message = "El teléfono no puede superar 30 caracteres")
    @Schema(description = "Teléfono de la sede", example = "3001234567")
    private String sedeTelefono;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "ACTIVO|INACTIVO", message = "El estado debe ser ACTIVO o INACTIVO")
    @Schema(description = "Estado de la sede", example = "ACTIVO", allowableValues = {"ACTIVO","INACTIVO"})
    private String sedeEstado;

    public String getSedeNombre() { return sedeNombre; }
    public void setSedeNombre(String sedeNombre) { this.sedeNombre = sedeNombre; }
    public String getSedeDireccion() { return sedeDireccion; }
    public void setSedeDireccion(String sedeDireccion) { this.sedeDireccion = sedeDireccion; }
    public String getSedeTelefono() { return sedeTelefono; }
    public void setSedeTelefono(String sedeTelefono) { this.sedeTelefono = sedeTelefono; }
    public String getSedeEstado() { return sedeEstado; }
    public void setSedeEstado(String sedeEstado) { this.sedeEstado = sedeEstado; }
}
