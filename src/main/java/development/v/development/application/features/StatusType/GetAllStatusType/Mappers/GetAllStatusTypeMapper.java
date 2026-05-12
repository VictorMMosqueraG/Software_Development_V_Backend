package development.v.development.application.features.StatusType.GetAllStatusType.Mappers;

import development.v.development.application.features.StatusType.GetAllStatusType.Dtos.GetAllStatusTypeQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllStatusTypeMapper {

    public static EntityFilter toFilter(GetAllStatusTypeQuery query) {
        return new EntityFilter(query)
                .addFilter("tesEstado", query.getTesEstado());
    }
}
