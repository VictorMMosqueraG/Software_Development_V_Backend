package development.v.development.application.features.DiningArea.CreateDiningArea;

import org.springframework.stereotype.Service;

import development.v.development.application.features.DiningArea.CreateDiningArea.Dtos.CreateDiningAreaRequestDto;
import development.v.development.application.features.DiningArea.CreateDiningArea.Mappers.CreateDiningAreaMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.DiningArea;
import development.v.development.domain.repositories.DiningAreaRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateDiningAreaUseCase {

    private final DiningAreaRepository repository;

    public CreateDiningAreaUseCase(DiningAreaRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<DiningArea> execute(CreateDiningAreaRequestDto request) {
        DiningArea domain = CreateDiningAreaMapper.toDomain(request);
        repository.save(domain);
        return DataResultDto.success(domain, Message.SUCCESS);
    }
}
