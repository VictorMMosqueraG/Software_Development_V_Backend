package development.v.development.application.features.Pqrs.UpdatePqrs.Dtos;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

public class UpdatePqrsRequest {

    @NotNull(message = "La fecha es requerida")
    @Schema(description = "Fecha del PQRS", example = "2026-01-15")
    private LocalDate pqrsFecha;

    @NotBlank(message = "La descripcion es requerida")
    @Schema(description = "Descripcion del PQRS", example = "Solicitud de informacion")
    private String pqrsDescripcion;

    @NotBlank(message = "El correo es requerido")
    @Email(message = "El correo no tiene un formato valido")
    @Size(max = 100, message = "El correo no puede superar 100 caracteres")
    @Schema(description = "Correo electronico", example = "usuario@email.com")
    private String pqrsCorreo;

    @NotBlank(message = "El telefono es requerido")
    @Size(max = 20, message = "El telefono no puede superar 20 caracteres")
    @Schema(description = "Telefono de contacto", example = "3001234567")
    private String pqrsTelefono;

    @NotNull(message = "El tipo de PQRS es requerido")
    @Schema(description = "ID del tipo de PQRS", example = "1")
    private Long tpqrsId;

    @NotNull(message = "El estado es requerido")
    @Schema(description = "ID del estado", example = "1")
    private Long estId;

    @Schema(description = "Respuesta del PQRS", example = "Se ha atendido su solicitud")
    private String pqrsRespuesta;

    @Schema(description = "ID del usuario que responde", example = "1")
    private Long usuIdResponde;

    public LocalDate getPqrsFecha() { return pqrsFecha; }
    public void setPqrsFecha(LocalDate pqrsFecha) { this.pqrsFecha = pqrsFecha; }
    public String getPqrsDescripcion() { return pqrsDescripcion; }
    public void setPqrsDescripcion(String pqrsDescripcion) { this.pqrsDescripcion = pqrsDescripcion; }
    public String getPqrsCorreo() { return pqrsCorreo; }
    public void setPqrsCorreo(String pqrsCorreo) { this.pqrsCorreo = pqrsCorreo; }
    public String getPqrsTelefono() { return pqrsTelefono; }
    public void setPqrsTelefono(String pqrsTelefono) { this.pqrsTelefono = pqrsTelefono; }
    public Long getTpqrsId() { return tpqrsId; }
    public void setTpqrsId(Long tpqrsId) { this.tpqrsId = tpqrsId; }
    public Long getEstId() { return estId; }
    public void setEstId(Long estId) { this.estId = estId; }
    public String getPqrsRespuesta() { return pqrsRespuesta; }
    public void setPqrsRespuesta(String pqrsRespuesta) { this.pqrsRespuesta = pqrsRespuesta; }
    public Long getUsuIdResponde() { return usuIdResponde; }
    public void setUsuIdResponde(Long usuIdResponde) { this.usuIdResponde = usuIdResponde; }
}
