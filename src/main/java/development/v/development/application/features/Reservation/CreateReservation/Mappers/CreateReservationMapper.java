package development.v.development.application.features.Reservation.CreateReservation.Mappers;

import development.v.development.application.features.Reservation.CreateReservation.Dtos.CreateReservationRequestDto;
import development.v.development.domain.models.Reservation;

public class CreateReservationMapper {

    public static Reservation toDomain(CreateReservationRequestDto request) {
        Reservation reservation = new Reservation();
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
