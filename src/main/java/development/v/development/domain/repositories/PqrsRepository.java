package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.Pqrs;
import development.v.development.domain.responses.PaginatedResultDto;

public interface PqrsRepository {
    Pqrs save(Pqrs pqrs);
    Optional<Pqrs> findById(Long pqrsId);
    PaginatedResultDto<List<Pqrs>> findAllPaginated(EntityFilter filter);
    Pqrs update(Pqrs pqrs);
    void delete(Long id);
}
