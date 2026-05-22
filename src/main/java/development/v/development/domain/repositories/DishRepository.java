package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.Dish;
import development.v.development.domain.responses.PaginatedResultDto;

public interface DishRepository {
    Dish save(Dish dish);
    Optional<Dish> findById(Integer id);
    PaginatedResultDto<List<Dish>> findAllPaginated(EntityFilter filter);
    Dish update(Dish dish);
    void delete(Integer id);
    boolean existsById(Integer id);
}

