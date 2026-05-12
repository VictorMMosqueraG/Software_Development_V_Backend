package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.Presentation;
import development.v.development.domain.responses.PaginatedResultDto;

public interface PresentationRepository {
    Presentation save(Presentation presentation);
    Optional<Presentation> findById(Long presId);
    PaginatedResultDto<List<Presentation>> findAllPaginated(EntityFilter filter);
    Presentation update(Presentation presentation);
    void delete(Long id);
}
