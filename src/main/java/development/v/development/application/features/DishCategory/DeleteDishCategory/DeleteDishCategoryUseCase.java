package development.v.development.application.features.DishCategory.DeleteDishCategory;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.DishCategory;
import development.v.development.domain.repositories.DishCategoryRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeleteDishCategoryUseCase {

    private final DishCategoryRepository repository;

    public DeleteDishCategoryUseCase(DishCategoryRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<DishCategory> execute(Long id) {
        DishCategory dishCategory = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
        repository.delete(id);
        return DataResultDto.success(dishCategory, Message.SUCCESS);
    }
}
