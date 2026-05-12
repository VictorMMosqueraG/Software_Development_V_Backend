package development.v.development.application.features.DishCategory.CreateDishCategory.Mappers;

import development.v.development.application.features.DishCategory.CreateDishCategory.Dtos.CreateDishCategoryRequestDto;
import development.v.development.domain.models.DishCategory;

public class CreateDishCategoryMapper {

    public static DishCategory toDomain(CreateDishCategoryRequestDto request) {
        DishCategory domain = new DishCategory();
        domain.setCatNombre(request.getCatNombre());
        domain.setCatImagen(request.getCatImagen());
        domain.setCatEstado(request.getCatEstado());
        return domain;
    }
}
