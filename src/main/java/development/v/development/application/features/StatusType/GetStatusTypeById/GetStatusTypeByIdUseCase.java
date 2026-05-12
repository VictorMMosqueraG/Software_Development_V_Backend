package development.v.development.application.features.StatusType.GetStatusTypeById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.StatusType;
import development.v.development.domain.repositories.StatusTypeRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetStatusTypeByIdUseCase {

    private final StatusTypeRepository repository;

    public GetStatusTypeByIdUseCase(StatusTypeRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<StatusType> execute(Long id) {
        StatusType statusType = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
        return DataResultDto.success(statusType, Message.SUCCESS);
    }
}
