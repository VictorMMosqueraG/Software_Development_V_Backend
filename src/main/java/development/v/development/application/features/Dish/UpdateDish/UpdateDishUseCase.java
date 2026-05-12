package development.v.development.application.features.Dish.UpdateDish;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Dish.UpdateDish.Dtos.UpdateDishRequest;
import development.v.development.application.features.Dish.UpdateDish.Mappers.UpdateDishMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Dish;
import development.v.development.domain.repositories.DishRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateDishUseCase {

    private final DishRepository dishRepository;

    public UpdateDishUseCase(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public DataResultDto<Dish> execute(Long id, UpdateDishRequest request) {
        dishRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        Dish domain = UpdateDishMapper.toDomain(id, request);
        Dish updated = dishRepository.update(domain);

        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
