package development.v.development.application.features.Supply.GetAllSupply;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Supply.GetAllSupply.Dtos.GetAllSupplyQuery;
import development.v.development.application.features.Supply.GetAllSupply.Mappers.GetAllSupplyMapper;
import development.v.development.domain.models.Supply;
import development.v.development.domain.repositories.SupplyRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllSupplyUseCase {

    private final SupplyRepository repository;

    public GetAllSupplyUseCase(SupplyRepository supplyRepository) {
        this.repository = supplyRepository;
    }

    public PaginatedResultDto<List<Supply>> execute(GetAllSupplyQuery query) {
        return repository.findAllPaginated(GetAllSupplyMapper.toFilter(query));
    }
}
