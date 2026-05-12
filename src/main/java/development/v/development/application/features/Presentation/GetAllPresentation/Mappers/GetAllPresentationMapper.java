package development.v.development.application.features.Presentation.GetAllPresentation.Mappers;

import development.v.development.application.features.Presentation.GetAllPresentation.Dtos.GetAllPresentationQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllPresentationMapper {

    public static EntityFilter toFilter(GetAllPresentationQuery query) {
        return new EntityFilter(query)
                .addFilter("presEstado", query.getPresEstado());
    }
}
