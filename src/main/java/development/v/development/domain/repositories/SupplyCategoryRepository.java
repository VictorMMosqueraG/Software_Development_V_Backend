package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.SupplyCategory;
import development.v.development.domain.responses.PaginatedResultDto;

public interface SupplyCategoryRepository {
    SupplyCategory save(SupplyCategory supplyCategory);
    Optional<SupplyCategory> findById(Long cinsId);
    PaginatedResultDto<List<SupplyCategory>> findAllPaginated(EntityFilter filter);
    SupplyCategory update(SupplyCategory supplyCategory);
    void delete(Long id);
}
