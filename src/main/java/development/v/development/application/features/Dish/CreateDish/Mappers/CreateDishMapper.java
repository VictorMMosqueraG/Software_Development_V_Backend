package development.v.development.application.features.Dish.CreateDish.Mappers;

import development.v.development.application.features.Dish.CreateDish.Dtos.CreateDishRequestDto;
import development.v.development.domain.models.Dish;

public class CreateDishMapper {

    public static Dish toDomain(CreateDishRequestDto request) {
        Dish dish = new Dish();
        dish.setCatId(request.getCatId());
        dish.setPlaDescripcion(request.getPlaDescripcion());
        dish.setPlaCodigo(request.getPlaCodigo());
        dish.setPlaPrecio(request.getPlaPrecio());
        dish.setPlaCosto(request.getPlaCosto());
        dish.setPlaImagen(request.getPlaImagen());
        dish.setEstId(request.getEstId());
        return dish;
    }
}
