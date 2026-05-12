package development.v.development.application.features.PqrsType.DeletePqrsType;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.PqrsType;
import development.v.development.domain.repositories.PqrsTypeRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeletePqrsTypeUseCase {
    private final PqrsTypeRepository repository;

    public DeletePqrsTypeUseCase(PqrsTypeRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<PqrsType> execute(Long id) {
        PqrsType model = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
        repository.delete(id);
        return DataResultDto.success(model, Message.SUCCESS);
    }
}
