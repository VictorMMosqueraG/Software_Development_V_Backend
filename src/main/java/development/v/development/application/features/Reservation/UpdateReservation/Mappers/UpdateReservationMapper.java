package development.v.development.application.features.Reservation.UpdateReservation.Mappers;

import development.v.development.application.features.Reservation.UpdateReservation.Dtos.UpdateReservationRequest;
import development.v.development.domain.models.Reservation;

public class UpdateReservationMapper {

    public static Reservation toDomain(Long id, UpdateReservationRequest request) {
        Reservation reservation = new Reservation();
        reservation.setResId(id);
        reservation.setSedeId(request.getSedeId());
        reservation.setResNombreCli(request.getResNombreCli());
        reservation.setResTelefono(request.getResTelefono());
        reservation.setResFechaHora(request.getResFechaHora());
        reservation.setResPersonas(request.getResPersonas());
        reservation.setMesaId(request.getMesaId());
        reservation.setResNota(request.getResNota());
        reservation.setResEstado(request.getResEstado());
        return reservation;
    }
}
