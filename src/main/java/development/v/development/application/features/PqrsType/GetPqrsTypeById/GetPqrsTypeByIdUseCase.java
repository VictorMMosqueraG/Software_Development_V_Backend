package development.v.development.application.features.PqrsType.GetPqrsTypeById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.PqrsType;
import development.v.development.domain.repositories.PqrsTypeRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetPqrsTypeByIdUseCase {
    private final PqrsTypeRepository repository;

    public GetPqrsTypeByIdUseCase(PqrsTypeRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<PqrsType> execute(Long id) {
        PqrsType model = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
        return DataResultDto.success(model, Message.SUCCESS);
    }
}
