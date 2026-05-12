package development.v.development.application.features.Configuration.UpdateConfiguration;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Configuration.UpdateConfiguration.Dtos.UpdateConfigurationRequest;
import development.v.development.application.features.Configuration.UpdateConfiguration.Mappers.UpdateConfigurationMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Configuration;
import development.v.development.domain.repositories.ConfigurationRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateConfigurationUseCase {
    private final ConfigurationRepository repository;

    public UpdateConfigurationUseCase(ConfigurationRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<Configuration> execute(Long id, UpdateConfigurationRequest request) {
        repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        Configuration domain = UpdateConfigurationMapper.toDomain(id, request);
        Configuration updated = repository.update(domain);
        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
