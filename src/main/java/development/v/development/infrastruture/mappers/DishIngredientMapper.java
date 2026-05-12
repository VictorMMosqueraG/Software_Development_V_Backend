package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.DishIngredient;
import development.v.development.infrastruture.entities.DishIngredientEntity;

public class DishIngredientMapper {
    public static DishIngredient toDomain(DishIngredientEntity entity) {
        DishIngredient dishIngredient = new DishIngredient();
        dishIngredient.setPiId(entity.getPiId());
        dishIngredient.setPlaId(entity.getPlaId());
        dishIngredient.setInsId(entity.getInsId());
        dishIngredient.setPiCantidad(entity.getPiCantidad());
        dishIngredient.setCreatedAt(entity.getCreatedAt());
        dishIngredient.setUpdatedAt(entity.getUpdatedAt());
        return dishIngredient;
    }

    public static DishIngredientEntity toEntity(DishIngredient dishIngredient) {
        DishIngredientEntity entity = new DishIngredientEntity();
        entity.setPiId(dishIngredient.getPiId());
        entity.setPlaId(dishIngredient.getPlaId());
        entity.setInsId(dishIngredient.getInsId());
        entity.setPiCantidad(dishIngredient.getPiCantidad());
        return entity;
    }
}
