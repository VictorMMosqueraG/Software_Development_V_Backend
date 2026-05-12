package development.v.development.application.features.Configuration.CreateConfiguration;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Configuration.CreateConfiguration.Dtos.CreateConfigurationRequestDto;
import development.v.development.application.features.Configuration.CreateConfiguration.Mappers.CreateConfigurationMapper;
import development.v.development.domain.exceptions.ConflictException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Configuration;
import development.v.development.domain.repositories.ConfigurationRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateConfigurationUseCase {

    private final ConfigurationRepository repository;

    public CreateConfigurationUseCase(ConfigurationRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<Configuration> execute(CreateConfigurationRequestDto request) {
        if (repository.existsByCfgClave(request.getCfgClave())) {
            throw new ConflictException(Message.ALREADY_EXIST + " Clave de configuracion");
        }

        Configuration domain = CreateConfigurationMapper.toDomain(request);
        repository.save(domain);
        return DataResultDto.success(domain, Message.SUCCESS);
    }
}
