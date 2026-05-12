package development.v.development.application.features.Supply.GetAllSupply.Mappers;

import development.v.development.application.features.Supply.GetAllSupply.Dtos.GetAllSupplyQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllSupplyMapper {

    public static EntityFilter toFilter(GetAllSupplyQuery query) {
        return new EntityFilter(query)
                .addFilter("insEstado", query.getInsEstado())
                .addFilter("sedeId", query.getSedeId())
                .addFilter("cinsId", query.getCinsId());
    }
}
