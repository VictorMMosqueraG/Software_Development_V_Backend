package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.Profile;
import development.v.development.domain.responses.PaginatedResultDto;

public interface ProfileRepository {
    Profile save(Profile profile);
    Optional<Profile> findById(Long perfId);
    PaginatedResultDto<List<Profile>> findAllPaginated(EntityFilter filter);
    Profile update(Profile profile);
    void delete(Long id);

    boolean existsByPerfDescripcion(String perfDescripcion);
}
