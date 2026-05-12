package development.v.development.application.features.Reservation.GetAllReservation;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Reservation.GetAllReservation.Dtos.GetAllReservationQuery;
import development.v.development.application.features.Reservation.GetAllReservation.Mappers.GetAllReservationMapper;
import development.v.development.domain.models.Reservation;
import development.v.development.domain.repositories.ReservationRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllReservationUseCase {

    private final ReservationRepository repository;

    public GetAllReservationUseCase(ReservationRepository reservationRepository) {
        this.repository = reservationRepository;
    }

    public PaginatedResultDto<List<Reservation>> execute(GetAllReservationQuery query) {
        return repository.findAllPaginated(GetAllReservationMapper.toFilter(query));
    }
}
