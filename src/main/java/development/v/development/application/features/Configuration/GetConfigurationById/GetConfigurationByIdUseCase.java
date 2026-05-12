package development.v.development.application.features.Configuration.GetConfigurationById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Configuration;
import development.v.development.domain.repositories.ConfigurationRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetConfigurationByIdUseCase {
    private final ConfigurationRepository repository;

    public GetConfigurationByIdUseCase(ConfigurationRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<Configuration> execute(Long id) {
        Configuration model = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
        return DataResultDto.success(model, Message.SUCCESS);
    }
}
