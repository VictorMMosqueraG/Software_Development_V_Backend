package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.PqrsType;
import development.v.development.domain.responses.PaginatedResultDto;

public interface PqrsTypeRepository {
    PqrsType save(PqrsType pqrsType);
    Optional<PqrsType> findById(Long tpqrsId);
    PaginatedResultDto<List<PqrsType>> findAllPaginated(EntityFilter filter);
    PqrsType update(PqrsType pqrsType);
    void delete(Long id);
}
