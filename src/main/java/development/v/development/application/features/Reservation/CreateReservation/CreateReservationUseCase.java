package development.v.development.application.features.Reservation.CreateReservation;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Reservation.CreateReservation.Dtos.CreateReservationRequestDto;
import development.v.development.application.features.Reservation.CreateReservation.Mappers.CreateReservationMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Reservation;
import development.v.development.domain.repositories.ReservationRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateReservationUseCase {

    private final ReservationRepository reservationRepository;

    public CreateReservationUseCase(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public DataResultDto<Reservation> execute(CreateReservationRequestDto request) {
        Reservation domain = CreateReservationMapper.toDomain(request);
        Reservation saved = reservationRepository.save(domain);
        return DataResultDto.success(saved, Message.SUCCESS);
    }
}
