package development.v.development.application.features.Profile.GetAllProfile.Mappers;

import development.v.development.application.features.Profile.GetAllProfile.Dtos.GetAllProfileQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllProfileMapper {

    public static EntityFilter toFilter(GetAllProfileQuery query) {
        return new EntityFilter(query)
                .addFilter("perfEstado", query.getPerfEstado());
    }
}
