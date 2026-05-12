package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.Configuration;
import development.v.development.domain.responses.PaginatedResultDto;

public interface ConfigurationRepository {
    Configuration save(Configuration configuration);
    Optional<Configuration> findById(Long cfgId);
    PaginatedResultDto<List<Configuration>> findAllPaginated(EntityFilter filter);
    Configuration update(Configuration configuration);
    void delete(Long id);

    boolean existsByCfgClave(String cfgClave);
}
