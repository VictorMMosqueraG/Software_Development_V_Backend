package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.DiningTable;
import development.v.development.domain.responses.PaginatedResultDto;

public interface DiningTableRepository {
    DiningTable save(DiningTable diningTable);
    Optional<DiningTable> findById(Long id);
    PaginatedResultDto<List<DiningTable>> findAllPaginated(EntityFilter filter);
    DiningTable update(DiningTable diningTable);
    void delete(Long id);
}
