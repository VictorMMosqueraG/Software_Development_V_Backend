package development.v.development.application.features.Dish.CreateDish;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import development.v.development.application.features.Dish.CreateDish.Dtos.CreateDishRequestDto;
import development.v.development.application.features.Dish.CreateDish.Mappers.CreateDishMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Dish;
import development.v.development.domain.repositories.DishRepository;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.infrastruture.config.FileStorageService;

@Service
public class CreateDishUseCase {

    private final DishRepository dishRepository;
    private final FileStorageService fileStorageService;

    public CreateDishUseCase(DishRepository dishRepository, FileStorageService fileStorageService) {
        this.dishRepository = dishRepository;
        this.fileStorageService = fileStorageService;
    }

    public DataResultDto<Dish> execute(CreateDishRequestDto request, MultipartFile image) {
        Dish dish = CreateDishMapper.toDomain(request);
        String storedImage = null;
        if (image != null && !image.isEmpty()) {
            storedImage = fileStorageService.storeFile(image);
            dish.setPlaImagen(storedImage);
        }
        try {
            Dish saved = dishRepository.save(dish);
            return DataResultDto.success(saved, Message.CREATED);
        } catch (RuntimeException ex) {
            if (storedImage != null) {
                fileStorageService.deleteFile(storedImage);
            }
            throw ex;
        }
    }
}

