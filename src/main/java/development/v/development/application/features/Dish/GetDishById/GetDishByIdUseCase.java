package development.v.development.application.features.Dish.GetDishById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Dish;
import development.v.development.domain.repositories.DishRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetDishByIdUseCase {

    private final DishRepository dishRepository;

    public GetDishByIdUseCase(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public DataResultDto<Dish> execute(Long id) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        return DataResultDto.success(dish, Message.SUCCESS);
    }
}
