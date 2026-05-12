package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.DiningArea;
import development.v.development.domain.responses.PaginatedResultDto;

public interface DiningAreaRepository {
    DiningArea save(DiningArea diningArea);
    Optional<DiningArea> findById(Long id);
    PaginatedResultDto<List<DiningArea>> findAllPaginated(EntityFilter filter);
    DiningArea update(DiningArea diningArea);
    void delete(Long id);
}
