package development.v.development.application.features.PqrsType.UpdatePqrsType;

import org.springframework.stereotype.Service;

import development.v.development.application.features.PqrsType.UpdatePqrsType.Dtos.UpdatePqrsTypeRequest;
import development.v.development.application.features.PqrsType.UpdatePqrsType.Mappers.UpdatePqrsTypeMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.PqrsType;
import development.v.development.domain.repositories.PqrsTypeRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdatePqrsTypeUseCase {
    private final PqrsTypeRepository repository;

    public UpdatePqrsTypeUseCase(PqrsTypeRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<PqrsType> execute(Long id, UpdatePqrsTypeRequest request) {
        repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        PqrsType domain = UpdatePqrsTypeMapper.toDomain(id, request);
        PqrsType updated = repository.update(domain);
        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
