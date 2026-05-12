package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.DishIngredient;
import development.v.development.domain.responses.PaginatedResultDto;

public interface DishIngredientRepository {
    DishIngredient save(DishIngredient dishIngredient);
    Optional<DishIngredient> findById(Long piId);
    PaginatedResultDto<List<DishIngredient>> findAllPaginated(EntityFilter filter);
    DishIngredient update(DishIngredient dishIngredient);
    void delete(Long id);
}
