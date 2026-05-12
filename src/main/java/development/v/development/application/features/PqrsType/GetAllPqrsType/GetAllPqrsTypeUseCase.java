package development.v.development.application.features.PqrsType.GetAllPqrsType;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.PqrsType.GetAllPqrsType.Dtos.GetAllPqrsTypeQuery;
import development.v.development.application.features.PqrsType.GetAllPqrsType.Mappers.GetAllPqrsTypeMapper;
import development.v.development.domain.models.PqrsType;
import development.v.development.domain.repositories.PqrsTypeRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllPqrsTypeUseCase {

    private final PqrsTypeRepository repository;

    public GetAllPqrsTypeUseCase(PqrsTypeRepository repository) {
        this.repository = repository;
    }

    public PaginatedResultDto<List<PqrsType>> execute(GetAllPqrsTypeQuery query) {
        return repository.findAllPaginated(GetAllPqrsTypeMapper.toFilter(query));
    }
}
