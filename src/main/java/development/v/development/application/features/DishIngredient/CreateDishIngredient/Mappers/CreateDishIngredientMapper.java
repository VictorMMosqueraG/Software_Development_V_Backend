package development.v.development.application.features.DishIngredient.CreateDishIngredient.Mappers;

import development.v.development.application.features.DishIngredient.CreateDishIngredient.Dtos.CreateDishIngredientRequestDto;
import development.v.development.domain.models.DishIngredient;

public class CreateDishIngredientMapper {

    public static DishIngredient toDomain(CreateDishIngredientRequestDto request) {
        DishIngredient dishIngredient = new DishIngredient();
        dishIngredient.setPlaId(request.getPlaId());
        dishIngredient.setInsId(request.getInsId());
        dishIngredient.setPiCantidad(request.getPiCantidad());
        return dishIngredient;
    }
}
