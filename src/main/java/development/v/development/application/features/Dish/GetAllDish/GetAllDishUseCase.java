package development.v.development.application.features.Dish.GetAllDish;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Dish.GetAllDish.Dtos.GetAllDishQuery;
import development.v.development.application.features.Dish.GetAllDish.Mappers.GetAllDishMapper;
import development.v.development.domain.models.Dish;
import development.v.development.domain.repositories.DishRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllDishUseCase {

    private final DishRepository repository;

    public GetAllDishUseCase(DishRepository dishRepository) {
        this.repository = dishRepository;
    }

    public PaginatedResultDto<List<Dish>> execute(GetAllDishQuery query) {
        return repository.findAllPaginated(GetAllDishMapper.toFilter(query));
    }
}
