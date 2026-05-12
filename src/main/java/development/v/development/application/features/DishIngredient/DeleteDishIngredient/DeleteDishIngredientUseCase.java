package development.v.development.application.features.DishIngredient.DeleteDishIngredient;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.DishIngredient;
import development.v.development.domain.repositories.DishIngredientRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeleteDishIngredientUseCase {

    private final DishIngredientRepository dishIngredientRepository;

    public DeleteDishIngredientUseCase(DishIngredientRepository dishIngredientRepository) {
        this.dishIngredientRepository = dishIngredientRepository;
    }

    public DataResultDto<DishIngredient> execute(Long id) {
        DishIngredient dishIngredient = dishIngredientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        dishIngredientRepository.delete(id);
        return DataResultDto.success(dishIngredient, Message.SUCCESS);
    }
}
