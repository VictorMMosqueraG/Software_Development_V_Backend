package development.v.development.application.features.Dish.Common.Mappers;

import development.v.development.application.features.Dish.Common.Dtos.DishResponseDto;
import development.v.development.domain.models.Dish;

public class DishResponseMapper {

    private DishResponseMapper() {
    }

    public static DishResponseDto toResponse(Dish dish) {
        if (dish == null) {
            return null;
        }

        DishResponseDto response = new DishResponseDto();
        response.setPlaId(dish.getPlaId());
        response.setPlaDescripcion(dish.getPlaDescripcion());
        response.setPlaPrecio(dish.getPlaPrecio());
        response.setEstId(dish.getEstId());
        response.setPlaImagen(dish.getPlaImagen());
        return response;
    }
}

