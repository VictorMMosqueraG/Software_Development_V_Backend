package development.v.development.application.features.SupplyCategory.GetAllSupplyCategory.Mappers;

import development.v.development.application.features.SupplyCategory.GetAllSupplyCategory.Dtos.GetAllSupplyCategoryQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllSupplyCategoryMapper {

    public static EntityFilter toFilter(GetAllSupplyCategoryQuery query) {
        return new EntityFilter(query)
                .addFilter("cinsEstado", query.getCinsEstado());
    }
}
