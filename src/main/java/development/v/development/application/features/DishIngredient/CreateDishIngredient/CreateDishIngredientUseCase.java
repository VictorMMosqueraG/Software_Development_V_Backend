package development.v.development.application.features.DishIngredient.CreateDishIngredient;

import org.springframework.stereotype.Service;

import development.v.development.application.features.DishIngredient.CreateDishIngredient.Dtos.CreateDishIngredientRequestDto;
import development.v.development.application.features.DishIngredient.CreateDishIngredient.Mappers.CreateDishIngredientMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.DishIngredient;
import development.v.development.domain.repositories.DishIngredientRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateDishIngredientUseCase {

    private final DishIngredientRepository dishIngredientRepository;

    public CreateDishIngredientUseCase(DishIngredientRepository dishIngredientRepository) {
        this.dishIngredientRepository = dishIngredientRepository;
    }

    public DataResultDto<DishIngredient> execute(CreateDishIngredientRequestDto request) {
        DishIngredient domain = CreateDishIngredientMapper.toDomain(request);
        dishIngredientRepository.save(domain);
        return DataResultDto.success(domain, Message.SUCCESS);
    }
}
