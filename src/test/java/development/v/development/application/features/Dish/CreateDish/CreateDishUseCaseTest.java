package development.v.development.application.features.Dish.CreateDish;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import development.v.development.application.features.Dish.CreateDish.Dtos.CreateDishRequestDto;
import development.v.development.domain.models.Dish;
import development.v.development.domain.repositories.DishRepository;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.infrastruture.config.FileStorageService;

@ExtendWith(MockitoExtension.class)
class CreateDishUseCaseTest {

    @Mock
    private DishRepository dishRepository;

    @Mock
    private FileStorageService fileStorageService;

    @InjectMocks
    private CreateDishUseCase createDishUseCase;

    @Test
    void shouldPersistAndReturnPublicImageUrlWhenImageIsProvided() {
        CreateDishRequestDto request = new CreateDishRequestDto();
        request.setPlaDescripcion("Bandeja paisa");
        request.setPlaPrecio(25000f);
        request.setEstId(1);

        String publicUrl = "http://localhost:8080/uploads/platos/test-file.png";
        MockMultipartFile file = new MockMultipartFile("plaImagen", "test.png", "image/png", "fake-image".getBytes());

        when(fileStorageService.storeFile(file)).thenReturn(publicUrl);
        when(dishRepository.save(any(Dish.class))).thenAnswer(invocation -> {
            Dish saved = invocation.getArgument(0);
            saved.setPlaId(99);
            return saved;
        });

        DataResultDto<Dish> result = createDishUseCase.execute(request, file);

        ArgumentCaptor<Dish> dishCaptor = ArgumentCaptor.forClass(Dish.class);
        verify(dishRepository).save(dishCaptor.capture());

        Dish persistedDish = dishCaptor.getValue();
        assertEquals(publicUrl, persistedDish.getPlaImagen());
        assertEquals(publicUrl, result.getResults().getPlaImagen());
        assertEquals(99, result.getResults().getPlaId());
    }
}

