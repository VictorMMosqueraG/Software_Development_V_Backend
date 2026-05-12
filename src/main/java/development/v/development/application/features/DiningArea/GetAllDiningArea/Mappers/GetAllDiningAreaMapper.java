package development.v.development.application.features.DiningArea.GetAllDiningArea.Mappers;

import development.v.development.application.features.DiningArea.GetAllDiningArea.Dtos.GetAllDiningAreaQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllDiningAreaMapper {

    public static EntityFilter toFilter(GetAllDiningAreaQuery query) {
        return new EntityFilter(query)
                .addFilter("areaEstado", query.getAreaEstado())
                .addFilter("sedeId", query.getSedeId());
    }
}
