package development.v.development.application.features.DishIngredient.GetAllDishIngredient;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.DishIngredient.GetAllDishIngredient.Dtos.GetAllDishIngredientQuery;
import development.v.development.application.features.DishIngredient.GetAllDishIngredient.Mappers.GetAllDishIngredientMapper;
import development.v.development.domain.models.DishIngredient;
import development.v.development.domain.repositories.DishIngredientRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllDishIngredientUseCase {

    private final DishIngredientRepository repository;

    public GetAllDishIngredientUseCase(DishIngredientRepository dishIngredientRepository) {
        this.repository = dishIngredientRepository;
    }

    public PaginatedResultDto<List<DishIngredient>> execute(GetAllDishIngredientQuery query) {
        return repository.findAllPaginated(GetAllDishIngredientMapper.toFilter(query));
    }
}
