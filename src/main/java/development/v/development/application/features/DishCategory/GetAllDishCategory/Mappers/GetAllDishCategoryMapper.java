package development.v.development.application.features.DishCategory.GetAllDishCategory.Mappers;

import development.v.development.application.features.DishCategory.GetAllDishCategory.Dtos.GetAllDishCategoryQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllDishCategoryMapper {

    public static EntityFilter toFilter(GetAllDishCategoryQuery query) {
        return new EntityFilter(query)
                .addFilter("catEstado", query.getCatEstado());
    }
}
