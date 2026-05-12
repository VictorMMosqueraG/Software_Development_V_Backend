package development.v.development.application.features.Pqrs.GetAllPqrs.Mappers;

import development.v.development.application.features.Pqrs.GetAllPqrs.Dtos.GetAllPqrsQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllPqrsMapper {
    public static EntityFilter toFilter(GetAllPqrsQuery query) {
        return new EntityFilter(query)
                .addFilter("tpqrsId", query.getTpqrsId())
                .addFilter("estId", query.getEstId());
    }
}
