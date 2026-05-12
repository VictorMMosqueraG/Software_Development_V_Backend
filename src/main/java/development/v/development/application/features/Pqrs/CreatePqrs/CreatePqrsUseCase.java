package development.v.development.application.features.Pqrs.CreatePqrs;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Pqrs.CreatePqrs.Dtos.CreatePqrsRequestDto;
import development.v.development.application.features.Pqrs.CreatePqrs.Mappers.CreatePqrsMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Pqrs;
import development.v.development.domain.repositories.PqrsRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreatePqrsUseCase {

    private final PqrsRepository repository;

    public CreatePqrsUseCase(PqrsRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<Pqrs> execute(CreatePqrsRequestDto request) {
        Pqrs domain = CreatePqrsMapper.toDomain(request);
        repository.save(domain);
        return DataResultDto.success(domain, Message.SUCCESS);
    }
}
