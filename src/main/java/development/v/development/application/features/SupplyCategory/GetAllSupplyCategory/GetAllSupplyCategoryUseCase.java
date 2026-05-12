package development.v.development.application.features.SupplyCategory.GetAllSupplyCategory;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.SupplyCategory.GetAllSupplyCategory.Dtos.GetAllSupplyCategoryQuery;
import development.v.development.application.features.SupplyCategory.GetAllSupplyCategory.Mappers.GetAllSupplyCategoryMapper;
import development.v.development.domain.models.SupplyCategory;
import development.v.development.domain.repositories.SupplyCategoryRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllSupplyCategoryUseCase {

    private final SupplyCategoryRepository repository;

    public GetAllSupplyCategoryUseCase(SupplyCategoryRepository supplyCategoryRepository) {
        this.repository = supplyCategoryRepository;
    }

    public PaginatedResultDto<List<SupplyCategory>> execute(GetAllSupplyCategoryQuery query) {
        return repository.findAllPaginated(GetAllSupplyCategoryMapper.toFilter(query));
    }
}
