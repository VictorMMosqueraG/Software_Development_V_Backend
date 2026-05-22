package development.v.development.application.features.Dish.DeleteDish;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Dish;
import development.v.development.domain.repositories.DishRepository;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.infrastruture.config.FileStorageService;

@Service
public class DeleteDishUseCase {

    private final DishRepository dishRepository;
    private final FileStorageService fileStorageService;

    public DeleteDishUseCase(DishRepository dishRepository, FileStorageService fileStorageService) {
        this.dishRepository = dishRepository;
        this.fileStorageService = fileStorageService;
    }

    public DataResultDto<Void> execute(Integer id) {
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        fileStorageService.deleteFile(dish.getPlaImagen());
        dishRepository.delete(id);
        return DataResultDto.success(null, Message.SUCCESS);
    }
}

