package development.v.development.application.features.DishCategory.GetDishCategoryById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.DishCategory;
import development.v.development.domain.repositories.DishCategoryRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetDishCategoryByIdUseCase {

    private final DishCategoryRepository repository;

    public GetDishCategoryByIdUseCase(DishCategoryRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<DishCategory> execute(Long id) {
        DishCategory dishCategory = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
        return DataResultDto.success(dishCategory, Message.SUCCESS);
    }
}
