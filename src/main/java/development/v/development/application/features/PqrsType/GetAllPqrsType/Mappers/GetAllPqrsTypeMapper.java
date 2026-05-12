package development.v.development.application.features.PqrsType.GetAllPqrsType.Mappers;

import development.v.development.application.features.PqrsType.GetAllPqrsType.Dtos.GetAllPqrsTypeQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllPqrsTypeMapper {
    public static EntityFilter toFilter(GetAllPqrsTypeQuery query) {
        return new EntityFilter(query)
                .addFilter("tpqrsEstado", query.getTpqrsEstado());
    }
}
