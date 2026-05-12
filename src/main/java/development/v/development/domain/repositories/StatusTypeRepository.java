package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.StatusType;
import development.v.development.domain.responses.PaginatedResultDto;

public interface StatusTypeRepository {
    StatusType save(StatusType statusType);
    Optional<StatusType> findById(Long id);
    PaginatedResultDto<List<StatusType>> findAllPaginated(EntityFilter filter);
    StatusType update(StatusType statusType);
    void delete(Long id);
}
