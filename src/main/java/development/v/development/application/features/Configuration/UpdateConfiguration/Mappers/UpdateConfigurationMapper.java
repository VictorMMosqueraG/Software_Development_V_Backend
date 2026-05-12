package development.v.development.application.features.Configuration.UpdateConfiguration.Mappers;

import development.v.development.application.features.Configuration.UpdateConfiguration.Dtos.UpdateConfigurationRequest;
import development.v.development.domain.models.Configuration;

public class UpdateConfigurationMapper {
    public static Configuration toDomain(Long id, UpdateConfigurationRequest request) {
        Configuration model = new Configuration();
        model.setCfgId(id);
        model.setCfgClave(request.getCfgClave());
        model.setCfgValor(request.getCfgValor());
        return model;
    }
}
