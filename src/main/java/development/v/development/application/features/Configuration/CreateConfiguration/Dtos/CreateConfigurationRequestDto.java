package development.v.development.application.features.Configuration.CreateConfiguration.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Request para crear una configuracion")
public class CreateConfigurationRequestDto {

    @NotBlank(message = "La clave es requerida")
    @Size(max = 100, message = "La clave no puede superar 100 caracteres")
    @Schema(description = "Clave de configuracion unica", example = "NOMBRE_EMPRESA")
    private String cfgClave;

    @Schema(description = "Valor de la configuracion", example = "Mi Restaurante")
    private String cfgValor;

    public String getCfgClave() { return cfgClave; }
    public void setCfgClave(String cfgClave) { this.cfgClave = cfgClave; }
    public String getCfgValor() { return cfgValor; }
    public void setCfgValor(String cfgValor) { this.cfgValor = cfgValor; }
}
