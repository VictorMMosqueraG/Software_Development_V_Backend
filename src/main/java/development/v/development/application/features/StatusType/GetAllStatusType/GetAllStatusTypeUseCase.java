package development.v.development.application.features.StatusType.GetAllStatusType;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.StatusType.GetAllStatusType.Dtos.GetAllStatusTypeQuery;
import development.v.development.application.features.StatusType.GetAllStatusType.Mappers.GetAllStatusTypeMapper;
import development.v.development.domain.models.StatusType;
import development.v.development.domain.repositories.StatusTypeRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllStatusTypeUseCase {

    private final StatusTypeRepository repository;

    public GetAllStatusTypeUseCase(StatusTypeRepository repository) {
        this.repository = repository;
    }

    public PaginatedResultDto<List<StatusType>> execute(GetAllStatusTypeQuery query) {
        return repository.findAllPaginated(GetAllStatusTypeMapper.toFilter(query));
    }
}
