package development.v.development.application.features.Reservation.UpdateReservation;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Reservation.UpdateReservation.Dtos.UpdateReservationRequest;
import development.v.development.application.features.Reservation.UpdateReservation.Mappers.UpdateReservationMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Reservation;
import development.v.development.domain.repositories.ReservationRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateReservationUseCase {

    private final ReservationRepository reservationRepository;

    public UpdateReservationUseCase(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public DataResultDto<Reservation> execute(Long id, UpdateReservationRequest request) {
        reservationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        Reservation domain = UpdateReservationMapper.toDomain(id, request);
        Reservation updated = reservationRepository.update(domain);

        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
