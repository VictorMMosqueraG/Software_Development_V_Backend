package development.v.development.application.features.DishCategory.UpdateDishCategory.Mappers;

import development.v.development.application.features.DishCategory.UpdateDishCategory.Dtos.UpdateDishCategoryRequest;
import development.v.development.domain.models.DishCategory;

public class UpdateDishCategoryMapper {

    public static DishCategory toDomain(Long id, UpdateDishCategoryRequest request) {
        DishCategory domain = new DishCategory();
        domain.setCatId(id);
        domain.setCatNombre(request.getCatNombre());
        domain.setCatImagen(request.getCatImagen());
        domain.setCatEstado(request.getCatEstado());
        return domain;
    }
}
