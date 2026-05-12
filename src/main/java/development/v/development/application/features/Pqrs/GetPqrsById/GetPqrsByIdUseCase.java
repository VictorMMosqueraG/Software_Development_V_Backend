package development.v.development.application.features.Pqrs.GetPqrsById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Pqrs;
import development.v.development.domain.repositories.PqrsRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetPqrsByIdUseCase {
    private final PqrsRepository repository;

    public GetPqrsByIdUseCase(PqrsRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<Pqrs> execute(Long id) {
        Pqrs model = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
        return DataResultDto.success(model, Message.SUCCESS);
    }
}
