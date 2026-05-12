package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.Branch;
import development.v.development.domain.responses.PaginatedResultDto;

public interface BranchRepository {
    Branch save(Branch branch);
    Optional<Branch> findById(Long sedeId);
    PaginatedResultDto<List<Branch>> findAllPaginated(EntityFilter filter);
    Branch update(Branch branch);
    void delete(Long id);

    boolean existsBySedeNombre(String sedeNombre);
}
