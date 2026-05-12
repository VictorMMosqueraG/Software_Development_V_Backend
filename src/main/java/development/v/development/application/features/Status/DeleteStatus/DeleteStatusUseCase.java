package development.v.development.application.features.Status.DeleteStatus;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Status;
import development.v.development.domain.repositories.StatusRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeleteStatusUseCase {

    private final StatusRepository repository;

    public DeleteStatusUseCase(StatusRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<Status> execute(Long id) {
        Status status = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
        repository.delete(id);
        return DataResultDto.success(status, Message.SUCCESS);
    }
}
