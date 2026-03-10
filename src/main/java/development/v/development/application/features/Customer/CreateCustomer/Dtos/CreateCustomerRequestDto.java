package development.v.development.application.features.Customer.CreateCustomer.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(description = "Request para crear un customer")
public class CreateCustomerRequestDto {
    @NotBlank(message = "El nombre es requerido")
    @Size(max = 60, message = "El nombre no puede superar 60 caracteres")
    @Schema(description = "Nombre del cliente", example = "Juan")
    private String cliNombre;

    @NotBlank(message = "Los apellidos son requeridos")
    @Size(max = 60, message = "Los apellidos no pueden superar 60 caracteres")
    @Schema(description = "Apellidos del cliente", example = "Pérez García")
    private String cliApellidos;

    @NotBlank(message = "El tipo de documento es requerido")
    @Pattern(regexp = "CC|NIT|CE|Pasaporte", message = "Tipo documento debe ser CC, NIT, CE o Pasaporte")
    @Schema(description = "Tipo de documento", example = "CC", allowableValues = {"CC","NIT","CE","Pasaporte"})
    private String cliTipoDocumento;

    @Size(max = 30, message = "El número de documento no puede superar 30 caracteres")
    @Schema(description = "Número de documento único", example = "1234567890")
    @NotBlank(message = "El número de documento es requerido")
    private String cliNumDocumento;

    @Size(max = 100, message = "La dirección no puede superar 100 caracteres")
    @Schema(description = "Dirección del cliente", example = "Calle 10 # 5-20")
    private String cliDireccion;

    @Size(max = 20, message = "El teléfono no puede superar 20 caracteres")
    @Schema(description = "Teléfono de contacto", example = "3001234567")
    private String cliTelefono;

    @Email(message = "El correo no tiene un formato válido")
    @Size(max = 100, message = "El correo no puede superar 100 caracteres")
    @Schema(description = "Correo electrónico único", example = "juan@email.com")
    @NotBlank(message = "El correo es requerido")
    private String cliCorreo;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "ACTIVO|INACTIVO", message = "El estado debe ser ACTIVO o INACTIVO")
    @Schema(description = "Estado del cliente", example = "ACTIVO", allowableValues = {"ACTIVO","INACTIVO"})
    private String cliEstado;

    public String getCliNombre() { return cliNombre; }
    public void setCliNombre(String cliNombre) { this.cliNombre = cliNombre; }
    public String getCliApellidos() { return cliApellidos; }
    public void setCliApellidos(String cliApellidos) { this.cliApellidos = cliApellidos; }
    public String getCliTipoDocumento() { return cliTipoDocumento; }
    public void setCliTipoDocumento(String cliTipoDocumento) { this.cliTipoDocumento = cliTipoDocumento; }
    public String getCliNumDocumento() { return cliNumDocumento; }
    public void setCliNumDocumento(String cliNumDocumento) { this.cliNumDocumento = cliNumDocumento; }
    public String getCliDireccion() { return cliDireccion; }
    public void setCliDireccion(String cliDireccion) { this.cliDireccion = cliDireccion; }
    public String getCliTelefono() { return cliTelefono; }
    public void setCliTelefono(String cliTelefono) { this.cliTelefono = cliTelefono; }
    public String getCliCorreo() { return cliCorreo; }
    public void setCliCorreo(String cliCorreo) { this.cliCorreo = cliCorreo; }
    public String getCliEstado() { return cliEstado; }
    public void setCliEstado(String cliEstado) { this.cliEstado = cliEstado; }
}
