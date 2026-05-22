package development.v.development.application.features.Dish.CreateDish.Mappers;

import development.v.development.application.features.Dish.CreateDish.Dtos.CreateDishRequestDto;
import development.v.development.domain.models.Dish;

public class CreateDishMapper {
    public static Dish toDomain(CreateDishRequestDto dto) {
        Dish dish = new Dish();
        dish.setPlaDescripcion(dto.getPlaDescripcion());
        dish.setPlaPrecio(dto.getPlaPrecio());
        dish.setEstId(dto.getEstId());
        return dish;
    }
}

