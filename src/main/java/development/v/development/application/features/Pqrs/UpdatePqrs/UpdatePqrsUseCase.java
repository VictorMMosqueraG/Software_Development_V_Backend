package development.v.development.application.features.Pqrs.UpdatePqrs;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Pqrs.UpdatePqrs.Dtos.UpdatePqrsRequest;
import development.v.development.application.features.Pqrs.UpdatePqrs.Mappers.UpdatePqrsMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Pqrs;
import development.v.development.domain.repositories.PqrsRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdatePqrsUseCase {
    private final PqrsRepository repository;

    public UpdatePqrsUseCase(PqrsRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<Pqrs> execute(Long id, UpdatePqrsRequest request) {
        repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        Pqrs domain = UpdatePqrsMapper.toDomain(id, request);
        Pqrs updated = repository.update(domain);
        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
