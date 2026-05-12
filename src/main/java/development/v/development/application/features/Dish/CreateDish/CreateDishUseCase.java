package development.v.development.application.features.Dish.CreateDish;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Dish.CreateDish.Dtos.CreateDishRequestDto;
import development.v.development.application.features.Dish.CreateDish.Mappers.CreateDishMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Dish;
import development.v.development.domain.repositories.DishRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateDishUseCase {

    private final DishRepository dishRepository;

    public CreateDishUseCase(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public DataResultDto<Dish> execute(CreateDishRequestDto request) {
        Dish domain = CreateDishMapper.toDomain(request);
        Dish saved = dishRepository.save(domain);
        return DataResultDto.success(saved, Message.SUCCESS);
    }
}
