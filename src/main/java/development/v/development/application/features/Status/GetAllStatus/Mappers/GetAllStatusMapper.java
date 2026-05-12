package development.v.development.application.features.Status.GetAllStatus.Mappers;

import development.v.development.application.features.Status.GetAllStatus.Dtos.GetAllStatusQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllStatusMapper {

    public static EntityFilter toFilter(GetAllStatusQuery query) {
        return new EntityFilter(query)
                .addFilter("estEstado", query.getEstEstado())
                .addFilter("tesId", query.getTesId());
    }
}
