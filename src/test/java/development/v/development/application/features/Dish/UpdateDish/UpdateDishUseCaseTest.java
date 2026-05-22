package development.v.development.application.features.Dish.UpdateDish;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;

import development.v.development.application.features.Dish.UpdateDish.Dtos.UpdateDishRequestDto;
import development.v.development.domain.models.Dish;
import development.v.development.domain.repositories.DishRepository;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.infrastruture.config.FileStorageService;

@ExtendWith(MockitoExtension.class)
class UpdateDishUseCaseTest {

    @Mock
    private DishRepository dishRepository;

    @Mock
    private FileStorageService fileStorageService;

    @InjectMocks
    private UpdateDishUseCase updateDishUseCase;

    @Test
    void shouldReplacePublicImageUrlWhenNewImageIsProvided() {
        Dish existingDish = new Dish();
        existingDish.setPlaId(10);
        existingDish.setPlaDescripcion("Plato anterior");
        existingDish.setPlaPrecio(10000f);
        existingDish.setEstId(1);
        existingDish.setPlaImagen("http://localhost:8080/uploads/platos/old.png");

        UpdateDishRequestDto request = new UpdateDishRequestDto();
        request.setPlaDescripcion("Plato actualizado");

        MockMultipartFile newFile = new MockMultipartFile("plaImagen", "new.webp", "image/webp", "new".getBytes());
        String newImageUrl = "http://localhost:8080/uploads/platos/new.webp";

        when(dishRepository.findById(10)).thenReturn(Optional.of(existingDish));
        when(fileStorageService.storeFile(newFile)).thenReturn(newImageUrl);
        when(dishRepository.update(any(Dish.class))).thenAnswer(invocation -> invocation.getArgument(0));

        DataResultDto<Dish> result = updateDishUseCase.execute(10, request, newFile);

        ArgumentCaptor<Dish> dishCaptor = ArgumentCaptor.forClass(Dish.class);
        verify(dishRepository).update(dishCaptor.capture());
        verify(fileStorageService).deleteFile("http://localhost:8080/uploads/platos/old.png");

        Dish updatedDish = dishCaptor.getValue();
        assertEquals("Plato actualizado", updatedDish.getPlaDescripcion());
        assertEquals(newImageUrl, updatedDish.getPlaImagen());
        assertEquals(newImageUrl, result.getResults().getPlaImagen());
    }

    @Test
    void shouldKeepExistingImageWhenUpdateDoesNotReceiveImage() {
        Dish existingDish = new Dish();
        existingDish.setPlaId(15);
        existingDish.setPlaDescripcion("Original");
        existingDish.setPlaPrecio(12000f);
        existingDish.setEstId(1);
        existingDish.setPlaImagen("http://localhost:8080/uploads/platos/keep.png");

        UpdateDishRequestDto request = new UpdateDishRequestDto();
        request.setPlaPrecio(15000f);

        when(dishRepository.findById(15)).thenReturn(Optional.of(existingDish));
        when(dishRepository.update(any(Dish.class))).thenAnswer(invocation -> invocation.getArgument(0));

        DataResultDto<Dish> result = updateDishUseCase.execute(15, request, null);

        verify(fileStorageService, never()).storeFile(any());
        verify(fileStorageService, never()).deleteFile(any());
        assertEquals("http://localhost:8080/uploads/platos/keep.png", result.getResults().getPlaImagen());
        assertEquals(15000f, result.getResults().getPlaPrecio());
    }
}

