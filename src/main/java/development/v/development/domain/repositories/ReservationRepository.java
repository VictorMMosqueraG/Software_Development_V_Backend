package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.Reservation;
import development.v.development.domain.responses.PaginatedResultDto;

public interface ReservationRepository {
    Reservation save(Reservation reservation);
    Optional<Reservation> findById(Long resId);
    PaginatedResultDto<List<Reservation>> findAllPaginated(EntityFilter filter);
    Reservation update(Reservation reservation);
    void delete(Long id);
}
