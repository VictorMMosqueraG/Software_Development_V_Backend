package development.v.development.application.features.Pqrs.GetAllPqrs;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Pqrs.GetAllPqrs.Dtos.GetAllPqrsQuery;
import development.v.development.application.features.Pqrs.GetAllPqrs.Mappers.GetAllPqrsMapper;
import development.v.development.domain.models.Pqrs;
import development.v.development.domain.repositories.PqrsRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllPqrsUseCase {

    private final PqrsRepository repository;

    public GetAllPqrsUseCase(PqrsRepository repository) {
        this.repository = repository;
    }

    public PaginatedResultDto<List<Pqrs>> execute(GetAllPqrsQuery query) {
        return repository.findAllPaginated(GetAllPqrsMapper.toFilter(query));
    }
}
