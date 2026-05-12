package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.Status;
import development.v.development.domain.responses.PaginatedResultDto;

public interface StatusRepository {
    Status save(Status status);
    Optional<Status> findById(Long id);
    PaginatedResultDto<List<Status>> findAllPaginated(EntityFilter filter);
    Status update(Status status);
    void delete(Long id);
}
