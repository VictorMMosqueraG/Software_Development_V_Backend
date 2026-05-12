package development.v.development.application.features.StatusType.UpdateStatusType;

import org.springframework.stereotype.Service;

import development.v.development.application.features.StatusType.UpdateStatusType.Dtos.UpdateStatusTypeRequest;
import development.v.development.application.features.StatusType.UpdateStatusType.Mappers.UpdateStatusTypeMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.StatusType;
import development.v.development.domain.repositories.StatusTypeRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateStatusTypeUseCase {

    private final StatusTypeRepository repository;

    public UpdateStatusTypeUseCase(StatusTypeRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<StatusType> execute(Long id, UpdateStatusTypeRequest request) {
        repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        StatusType domain = UpdateStatusTypeMapper.toDomain(id, request);
        StatusType updated = repository.update(domain);
        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
