package development.v.development.application.features.DishCategory.CreateDishCategory;

import org.springframework.stereotype.Service;

import development.v.development.application.features.DishCategory.CreateDishCategory.Dtos.CreateDishCategoryRequestDto;
import development.v.development.application.features.DishCategory.CreateDishCategory.Mappers.CreateDishCategoryMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.DishCategory;
import development.v.development.domain.repositories.DishCategoryRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateDishCategoryUseCase {

    private final DishCategoryRepository repository;

    public CreateDishCategoryUseCase(DishCategoryRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<DishCategory> execute(CreateDishCategoryRequestDto request) {
        DishCategory domain = CreateDishCategoryMapper.toDomain(request);
        repository.save(domain);
        return DataResultDto.success(domain, Message.SUCCESS);
    }
}
