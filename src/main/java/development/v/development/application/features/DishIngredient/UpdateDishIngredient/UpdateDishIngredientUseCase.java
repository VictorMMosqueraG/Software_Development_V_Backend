package development.v.development.application.features.DishIngredient.UpdateDishIngredient;

import org.springframework.stereotype.Service;

import development.v.development.application.features.DishIngredient.UpdateDishIngredient.Dtos.UpdateDishIngredientRequest;
import development.v.development.application.features.DishIngredient.UpdateDishIngredient.Mappers.UpdateDishIngredientMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.DishIngredient;
import development.v.development.domain.repositories.DishIngredientRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateDishIngredientUseCase {
    private final DishIngredientRepository dishIngredientRepository;

    public UpdateDishIngredientUseCase(DishIngredientRepository dishIngredientRepository) {
        this.dishIngredientRepository = dishIngredientRepository;
    }

    public DataResultDto<DishIngredient> execute(Long id, UpdateDishIngredientRequest request) {
        dishIngredientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        DishIngredient domain = UpdateDishIngredientMapper.toDomain(id, request);
        DishIngredient updated = dishIngredientRepository.update(domain);

        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
