package development.v.development.application.features.DishCategory.GetAllDishCategory;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.DishCategory.GetAllDishCategory.Dtos.GetAllDishCategoryQuery;
import development.v.development.application.features.DishCategory.GetAllDishCategory.Mappers.GetAllDishCategoryMapper;
import development.v.development.domain.models.DishCategory;
import development.v.development.domain.repositories.DishCategoryRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllDishCategoryUseCase {

    private final DishCategoryRepository repository;

    public GetAllDishCategoryUseCase(DishCategoryRepository repository) {
        this.repository = repository;
    }

    public PaginatedResultDto<List<DishCategory>> execute(GetAllDishCategoryQuery query) {
        return repository.findAllPaginated(GetAllDishCategoryMapper.toFilter(query));
    }
}
