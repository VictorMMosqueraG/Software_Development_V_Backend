package development.v.development.application.features.PqrsType.CreatePqrsType;

import org.springframework.stereotype.Service;

import development.v.development.application.features.PqrsType.CreatePqrsType.Dtos.CreatePqrsTypeRequestDto;
import development.v.development.application.features.PqrsType.CreatePqrsType.Mappers.CreatePqrsTypeMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.PqrsType;
import development.v.development.domain.repositories.PqrsTypeRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreatePqrsTypeUseCase {

    private final PqrsTypeRepository repository;

    public CreatePqrsTypeUseCase(PqrsTypeRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<PqrsType> execute(CreatePqrsTypeRequestDto request) {
        PqrsType domain = CreatePqrsTypeMapper.toDomain(request);
        repository.save(domain);
        return DataResultDto.success(domain, Message.SUCCESS);
    }
}
