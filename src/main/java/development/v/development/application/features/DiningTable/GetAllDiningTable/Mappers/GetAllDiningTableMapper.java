package development.v.development.application.features.DiningTable.GetAllDiningTable.Mappers;

import development.v.development.application.features.DiningTable.GetAllDiningTable.Dtos.GetAllDiningTableQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllDiningTableMapper {

    public static EntityFilter toFilter(GetAllDiningTableQuery query) {
        return new EntityFilter(query)
                .addFilter("estado", query.getEstado())
                .addFilter("sedeId", query.getSedeId())
                .addFilter("areaId", query.getAreaId());
    }
}
