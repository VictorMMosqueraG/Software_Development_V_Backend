package development.v.development.application.features.Branch.GetAllBranch;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Branch.GetAllBranch.Dtos.GetAllBranchQuery;
import development.v.development.application.features.Branch.GetAllBranch.Mappers.GetAllBranchMapper;
import development.v.development.domain.models.Branch;
import development.v.development.domain.repositories.BranchRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllBranchUseCase {

    private final BranchRepository repository;

    public GetAllBranchUseCase(BranchRepository branchRepository) {
        this.repository = branchRepository;
    }

    public PaginatedResultDto<List<Branch>> execute(GetAllBranchQuery query) {
        return repository.findAllPaginated(GetAllBranchMapper.toFilter(query));
    }
}
