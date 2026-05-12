package development.v.development.application.features.User.UpdateUser.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdateUserRequest {

    @NotBlank(message = "El nombre es requerido")
    @Size(max = 60, message = "El nombre no puede superar 60 caracteres")
    @Schema(description = "Nombre del usuario", example = "Juan")
    private String usuNombre;

    @NotBlank(message = "El apellido es requerido")
    @Size(max = 60, message = "El apellido no puede superar 60 caracteres")
    @Schema(description = "Apellido del usuario", example = "Pérez")
    private String usuApellido;

    @NotBlank(message = "La dirección es requerida")
    @Size(max = 100, message = "La dirección no puede superar 100 caracteres")
    @Schema(description = "Dirección del usuario", example = "Calle 10 # 5-20")
    private String usuDireccion;

    @NotBlank(message = "El teléfono es requerido")
    @Size(max = 20, message = "El teléfono no puede superar 20 caracteres")
    @Schema(description = "Teléfono del usuario", example = "3001234567")
    private String usuTelefono;

    @Schema(description = "ID del perfil asociado", example = "1")
    private Long perfId;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "ACTIVO|INACTIVO", message = "El estado debe ser ACTIVO o INACTIVO")
    @Schema(description = "Estado del usuario", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String usuEstado;

    public String getUsuNombre() { return usuNombre; }
    public void setUsuNombre(String usuNombre) { this.usuNombre = usuNombre; }
    public String getUsuApellido() { return usuApellido; }
    public void setUsuApellido(String usuApellido) { this.usuApellido = usuApellido; }
    public String getUsuDireccion() { return usuDireccion; }
    public void setUsuDireccion(String usuDireccion) { this.usuDireccion = usuDireccion; }
    public String getUsuTelefono() { return usuTelefono; }
    public void setUsuTelefono(String usuTelefono) { this.usuTelefono = usuTelefono; }
    public Long getPerfId() { return perfId; }
    public void setPerfId(Long perfId) { this.perfId = perfId; }
    public String getUsuEstado() { return usuEstado; }
    public void setUsuEstado(String usuEstado) { this.usuEstado = usuEstado; }
}
