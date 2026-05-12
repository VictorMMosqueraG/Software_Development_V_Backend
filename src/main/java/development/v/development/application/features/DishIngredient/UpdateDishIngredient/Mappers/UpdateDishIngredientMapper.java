package development.v.development.application.features.DishIngredient.UpdateDishIngredient.Mappers;

import development.v.development.application.features.DishIngredient.UpdateDishIngredient.Dtos.UpdateDishIngredientRequest;
import development.v.development.domain.models.DishIngredient;

public class UpdateDishIngredientMapper {

    public static DishIngredient toDomain(Long id, UpdateDishIngredientRequest request) {
        DishIngredient dishIngredient = new DishIngredient();
        dishIngredient.setPiId(id);
        dishIngredient.setPlaId(request.getPlaId());
        dishIngredient.setInsId(request.getInsId());
        dishIngredient.setPiCantidad(request.getPiCantidad());
        return dishIngredient;
    }
}
