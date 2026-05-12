package development.v.development.application.features.Status.GetAllStatus;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Status.GetAllStatus.Dtos.GetAllStatusQuery;
import development.v.development.application.features.Status.GetAllStatus.Mappers.GetAllStatusMapper;
import development.v.development.domain.models.Status;
import development.v.development.domain.repositories.StatusRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllStatusUseCase {

    private final StatusRepository repository;

    public GetAllStatusUseCase(StatusRepository repository) {
        this.repository = repository;
    }

    public PaginatedResultDto<List<Status>> execute(GetAllStatusQuery query) {
        return repository.findAllPaginated(GetAllStatusMapper.toFilter(query));
    }
}
