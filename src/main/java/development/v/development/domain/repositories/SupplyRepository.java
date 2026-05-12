package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.Supply;
import development.v.development.domain.responses.PaginatedResultDto;

public interface SupplyRepository {
    Supply save(Supply supply);
    Optional<Supply> findById(Long insId);
    PaginatedResultDto<List<Supply>> findAllPaginated(EntityFilter filter);
    Supply update(Supply supply);
    void delete(Long id);
}
