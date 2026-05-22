package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.Dish;
import development.v.development.infrastruture.entities.DishEntity;

public class DishMapper {

    public static Dish toDomain(DishEntity entity) {
        Dish dish = new Dish();
        dish.setPlaId(entity.getPlaId());
        dish.setPlaDescripcion(entity.getPlaDescripcion());
        dish.setPlaPrecio(entity.getPlaPrecio());
        dish.setEstId(entity.getEstId());
        dish.setPlaImagen(entity.getPlaImagen());
        return dish;
    }

    public static DishEntity toEntity(Dish dish) {
        DishEntity entity = new DishEntity();
        entity.setPlaId(dish.getPlaId());
        entity.setPlaDescripcion(dish.getPlaDescripcion());
        entity.setPlaPrecio(dish.getPlaPrecio());
        entity.setEstId(dish.getEstId());
        entity.setPlaImagen(dish.getPlaImagen());
        return entity;
    }
}

