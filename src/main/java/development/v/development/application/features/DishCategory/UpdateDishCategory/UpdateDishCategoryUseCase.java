package development.v.development.application.features.DishCategory.UpdateDishCategory;

import org.springframework.stereotype.Service;

import development.v.development.application.features.DishCategory.UpdateDishCategory.Dtos.UpdateDishCategoryRequest;
import development.v.development.application.features.DishCategory.UpdateDishCategory.Mappers.UpdateDishCategoryMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.DishCategory;
import development.v.development.domain.repositories.DishCategoryRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateDishCategoryUseCase {

    private final DishCategoryRepository repository;

    public UpdateDishCategoryUseCase(DishCategoryRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<DishCategory> execute(Long id, UpdateDishCategoryRequest request) {
        repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        DishCategory domain = UpdateDishCategoryMapper.toDomain(id, request);
        DishCategory updated = repository.update(domain);
        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
