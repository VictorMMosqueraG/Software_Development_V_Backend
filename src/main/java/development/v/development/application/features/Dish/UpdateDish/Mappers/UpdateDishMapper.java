package development.v.development.application.features.Dish.UpdateDish.Mappers;

import development.v.development.application.features.Dish.UpdateDish.Dtos.UpdateDishRequest;
import development.v.development.domain.models.Dish;

public class UpdateDishMapper {

    public static Dish toDomain(Long id, UpdateDishRequest request) {
        Dish dish = new Dish();
        dish.setPlaId(id);
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
