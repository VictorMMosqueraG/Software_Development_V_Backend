package development.v.development.application.features.Dish.GetAllDish.Mappers;

import development.v.development.application.features.Dish.GetAllDish.Dtos.GetAllDishQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllDishMapper {
    public static EntityFilter toFilter(GetAllDishQuery query) {
        return new EntityFilter(query)
                .addFilter("estId", query.getEstId());
    }
}

