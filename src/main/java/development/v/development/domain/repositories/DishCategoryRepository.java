package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.DishCategory;
import development.v.development.domain.responses.PaginatedResultDto;

public interface DishCategoryRepository {
    DishCategory save(DishCategory dishCategory);
    Optional<DishCategory> findById(Long id);
    PaginatedResultDto<List<DishCategory>> findAllPaginated(EntityFilter filter);
    DishCategory update(DishCategory dishCategory);
    void delete(Long id);
}
