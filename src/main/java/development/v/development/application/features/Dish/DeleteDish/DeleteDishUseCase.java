package development.v.development.application.features.Dish.DeleteDish;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Dish;
import development.v.development.domain.repositories.DishRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeleteDishUseCase {

    private final DishRepository dishRepository;

    public DeleteDishUseCase(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public DataResultDto<Dish> execute(Long id) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        dishRepository.delete(id);
        return DataResultDto.success(dish, Message.SUCCESS);
    }
}
