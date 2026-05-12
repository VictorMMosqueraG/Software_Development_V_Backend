package development.v.development.application.features.Configuration.GetAllConfiguration;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Configuration.GetAllConfiguration.Dtos.GetAllConfigurationQuery;
import development.v.development.application.features.Configuration.GetAllConfiguration.Mappers.GetAllConfigurationMapper;
import development.v.development.domain.models.Configuration;
import development.v.development.domain.repositories.ConfigurationRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllConfigurationUseCase {

    private final ConfigurationRepository repository;

    public GetAllConfigurationUseCase(ConfigurationRepository repository) {
        this.repository = repository;
    }

    public PaginatedResultDto<List<Configuration>> execute(GetAllConfigurationQuery query) {
        return repository.findAllPaginated(GetAllConfigurationMapper.toFilter(query));
    }
}
