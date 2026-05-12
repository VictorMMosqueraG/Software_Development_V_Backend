package development.v.development.application.features.User.GetAllUser.Mappers;

import development.v.development.application.features.User.GetAllUser.Dtos.GetAllUserQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllUserMapper {

    public static EntityFilter toFilter(GetAllUserQuery query) {
        return new EntityFilter(query)
                .addFilter("usuEstado", query.getUsuEstado())
                .addFilter("perfId", query.getPerfId());
    }
}
