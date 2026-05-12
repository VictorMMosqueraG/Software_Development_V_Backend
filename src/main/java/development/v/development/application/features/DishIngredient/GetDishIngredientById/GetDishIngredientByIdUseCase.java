package development.v.development.application.features.DishIngredient.GetDishIngredientById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.DishIngredient;
import development.v.development.domain.repositories.DishIngredientRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetDishIngredientByIdUseCase {
    private final DishIngredientRepository dishIngredientRepository;

    public GetDishIngredientByIdUseCase(DishIngredientRepository dishIngredientRepository) {
        this.dishIngredientRepository = dishIngredientRepository;
    }

    public DataResultDto<DishIngredient> execute(Long id) {
        DishIngredient dishIngredient = dishIngredientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        return DataResultDto.success(dishIngredient, Message.SUCCESS);
    }
}
