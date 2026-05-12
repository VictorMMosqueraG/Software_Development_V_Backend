package development.v.development.application.features.Configuration.CreateConfiguration.Mappers;

import development.v.development.application.features.Configuration.CreateConfiguration.Dtos.CreateConfigurationRequestDto;
import development.v.development.domain.models.Configuration;

public class CreateConfigurationMapper {
    public static Configuration toDomain(CreateConfigurationRequestDto request) {
        Configuration model = new Configuration();
        model.setCfgClave(request.getCfgClave());
        model.setCfgValor(request.getCfgValor());
        return model;
    }
}
