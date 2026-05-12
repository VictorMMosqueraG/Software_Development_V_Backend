package development.v.development.application.features.StatusType.CreateStatusType;

import org.springframework.stereotype.Service;

import development.v.development.application.features.StatusType.CreateStatusType.Dtos.CreateStatusTypeRequestDto;
import development.v.development.application.features.StatusType.CreateStatusType.Mappers.CreateStatusTypeMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.StatusType;
import development.v.development.domain.repositories.StatusTypeRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateStatusTypeUseCase {

    private final StatusTypeRepository repository;

    public CreateStatusTypeUseCase(StatusTypeRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<StatusType> execute(CreateStatusTypeRequestDto request) {
        StatusType domain = CreateStatusTypeMapper.toDomain(request);
        repository.save(domain);
        return DataResultDto.success(domain, Message.SUCCESS);
    }
}
