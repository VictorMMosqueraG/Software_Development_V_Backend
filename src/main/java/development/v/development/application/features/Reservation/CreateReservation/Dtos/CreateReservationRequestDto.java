package development.v.development.application.features.Reservation.CreateReservation.Dtos;

import java.time.LocalDateTime;

import development.v.development.infrastruture.enums.ReservationStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Request para crear una reservacion")
public class CreateReservationRequestDto {

    @NotNull(message = "La sede es requerida")
    @Schema(description = "ID de la sede", example = "1")
    private Long sedeId;

    @NotNull(message = "El nombre del cliente es requerido")
    @Size(max = 100, message = "El nombre del cliente no puede superar 100 caracteres")
    @Schema(description = "Nombre del cliente", example = "Juan Pérez")
    private String resNombreCli;

    @Size(max = 20, message = "El teléfono no puede superar 20 caracteres")
    @Schema(description = "Teléfono del cliente", example = "+573001234567")
    private String resTelefono;

    @NotNull(message = "La fecha y hora es requerida")
    @Schema(description = "Fecha y hora de la reservación", example = "2026-05-15T19:00:00")
    private LocalDateTime resFechaHora;

    @NotNull(message = "El número de personas es requerido")
    @Schema(description = "Número de personas", example = "4")
    private Integer resPersonas;

    @Schema(description = "ID de la mesa", example = "1")
    private Long mesaId;

    @Schema(description = "Nota de la reservación", example = "Mesa cerca de la ventana")
    private String resNota;

    @NotNull(message = "El estado es requerido")
    @Schema(description = "Estado de la reservación", example = "PENDIENTE")
    private ReservationStatus resEstado;

    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public String getResNombreCli() { return resNombreCli; }
    public void setResNombreCli(String resNombreCli) { this.resNombreCli = resNombreCli; }
    public String getResTelefono() { return resTelefono; }
    public void setResTelefono(String resTelefono) { this.resTelefono = resTelefono; }
    public LocalDateTime getResFechaHora() { return resFechaHora; }
    public void setResFechaHora(LocalDateTime resFechaHora) { this.resFechaHora = resFechaHora; }
    public Integer getResPersonas() { return resPersonas; }
    public void setResPersonas(Integer resPersonas) { this.resPersonas = resPersonas; }
    public Long getMesaId() { return mesaId; }
    public void setMesaId(Long mesaId) { this.mesaId = mesaId; }
    public String getResNota() { return resNota; }
    public void setResNota(String resNota) { this.resNota = resNota; }
    public ReservationStatus getResEstado() { return resEstado; }
    public void setResEstado(ReservationStatus resEstado) { this.resEstado = resEstado; }
}
