package development.v.development.application.features.Status.UpdateStatus;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Status.UpdateStatus.Dtos.UpdateStatusRequest;
import development.v.development.application.features.Status.UpdateStatus.Mappers.UpdateStatusMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Status;
import development.v.development.domain.repositories.StatusRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateStatusUseCase {

    private final StatusRepository repository;

    public UpdateStatusUseCase(StatusRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<Status> execute(Long id, UpdateStatusRequest request) {
        repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        Status domain = UpdateStatusMapper.toDomain(id, request);
        Status updated = repository.update(domain);
        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
