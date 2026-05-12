package development.v.development.application.features.DishIngredient.GetAllDishIngredient.Mappers;

import development.v.development.application.features.DishIngredient.GetAllDishIngredient.Dtos.GetAllDishIngredientQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllDishIngredientMapper {

    public static EntityFilter toFilter(GetAllDishIngredientQuery query) {
        return new EntityFilter(query)
                .addFilter("plaId", query.getPlaId())
                .addFilter("insId", query.getInsId());
    }
}
