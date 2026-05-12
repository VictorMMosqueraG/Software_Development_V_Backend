package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.ExpenseConcept;
import development.v.development.domain.responses.PaginatedResultDto;

public interface ExpenseConceptRepository {
    ExpenseConcept save(ExpenseConcept expenseConcept);
    Optional<ExpenseConcept> findById(Long conId);
    PaginatedResultDto<List<ExpenseConcept>> findAllPaginated(EntityFilter filter);
    ExpenseConcept update(ExpenseConcept expenseConcept);
    void delete(Long id);
}
