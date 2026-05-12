package development.v.development.application.features.DiningArea.GetAllDiningArea;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.DiningArea.GetAllDiningArea.Dtos.GetAllDiningAreaQuery;
import development.v.development.application.features.DiningArea.GetAllDiningArea.Mappers.GetAllDiningAreaMapper;
import development.v.development.domain.models.DiningArea;
import development.v.development.domain.repositories.DiningAreaRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllDiningAreaUseCase {

    private final DiningAreaRepository repository;

    public GetAllDiningAreaUseCase(DiningAreaRepository repository) {
        this.repository = repository;
    }

    public PaginatedResultDto<List<DiningArea>> execute(GetAllDiningAreaQuery query) {
        return repository.findAllPaginated(GetAllDiningAreaMapper.toFilter(query));
    }
}
