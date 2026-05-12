package development.v.development.application.features.Reservation.DeleteReservation;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Reservation;
import development.v.development.domain.repositories.ReservationRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeleteReservationUseCase {

    private final ReservationRepository reservationRepository;

    public DeleteReservationUseCase(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public DataResultDto<Reservation> execute(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        reservationRepository.delete(id);
        return DataResultDto.success(reservation, Message.SUCCESS);
    }
}
