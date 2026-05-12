package development.v.development.application.features.PaymentMethod.UpdatePaymentMethod.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdatePaymentMethodRequest {

    @NotBlank(message = "La descripcion es requerida")
    @Size(max = 60, message = "La descripcion no puede superar 60 caracteres")
    @Schema(description = "Descripcion de la forma de pago", example = "Efectivo")
    private String fpDescripcion;

    @NotBlank(message = "El estado es requerido")
    @Pattern(regexp = "ACTIVO|INACTIVO", message = "El estado debe ser ACTIVO o INACTIVO")
    @Schema(description = "Estado de la forma de pago", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String fpEstado;

    public String getFpDescripcion() { return fpDescripcion; }
    public void setFpDescripcion(String fpDescripcion) { this.fpDescripcion = fpDescripcion; }
    public String getFpEstado() { return fpEstado; }
    public void setFpEstado(String fpEstado) { this.fpEstado = fpEstado; }
}
