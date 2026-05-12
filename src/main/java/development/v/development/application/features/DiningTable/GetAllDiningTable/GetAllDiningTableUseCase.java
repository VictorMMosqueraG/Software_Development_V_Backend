package development.v.development.application.features.DiningTable.GetAllDiningTable;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.DiningTable.GetAllDiningTable.Dtos.GetAllDiningTableQuery;
import development.v.development.application.features.DiningTable.GetAllDiningTable.Mappers.GetAllDiningTableMapper;
import development.v.development.domain.models.DiningTable;
import development.v.development.domain.repositories.DiningTableRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllDiningTableUseCase {

    private final DiningTableRepository repository;

    public GetAllDiningTableUseCase(DiningTableRepository repository) {
        this.repository = repository;
    }

    public PaginatedResultDto<List<DiningTable>> execute(GetAllDiningTableQuery query) {
        return repository.findAllPaginated(GetAllDiningTableMapper.toFilter(query));
    }
}
