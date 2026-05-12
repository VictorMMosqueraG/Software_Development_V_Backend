package development.v.development.application.features.Status.CreateStatus;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Status.CreateStatus.Dtos.CreateStatusRequestDto;
import development.v.development.application.features.Status.CreateStatus.Mappers.CreateStatusMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Status;
import development.v.development.domain.repositories.StatusRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateStatusUseCase {

    private final StatusRepository repository;

    public CreateStatusUseCase(StatusRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<Status> execute(CreateStatusRequestDto request) {
        Status domain = CreateStatusMapper.toDomain(request);
        repository.save(domain);
        return DataResultDto.success(domain, Message.SUCCESS);
    }
}
