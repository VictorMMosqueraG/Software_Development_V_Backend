package development.v.development.application.features.Configuration.GetAllConfiguration.Mappers;

import development.v.development.application.features.Configuration.GetAllConfiguration.Dtos.GetAllConfigurationQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllConfigurationMapper {
    public static EntityFilter toFilter(GetAllConfigurationQuery query) {
        return new EntityFilter(query)
                .addFilter("cfgClave", query.getCfgClave());
    }
}
