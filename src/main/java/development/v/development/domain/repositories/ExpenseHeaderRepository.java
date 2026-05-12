package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.ExpenseHeader;
import development.v.development.domain.responses.PaginatedResultDto;

public interface ExpenseHeaderRepository {
    ExpenseHeader save(ExpenseHeader expenseHeader);
    Optional<ExpenseHeader> findById(Long egrId);
    PaginatedResultDto<List<ExpenseHeader>> findAllPaginated(EntityFilter filter);
    ExpenseHeader update(ExpenseHeader expenseHeader);
    void delete(Long id);

    boolean existsByNoEgreso(Long noEgreso);
}
