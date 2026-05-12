package development.v.development.application.features.ExpenseConcept.GetAllExpenseConcept;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.ExpenseConcept.GetAllExpenseConcept.Dtos.GetAllExpenseConceptQuery;
import development.v.development.application.features.ExpenseConcept.GetAllExpenseConcept.Mappers.GetAllExpenseConceptMapper;
import development.v.development.domain.models.ExpenseConcept;
import development.v.development.domain.repositories.ExpenseConceptRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllExpenseConceptUseCase {

    private final ExpenseConceptRepository repository;

    public GetAllExpenseConceptUseCase(ExpenseConceptRepository repository) {
        this.repository = repository;
    }

    public PaginatedResultDto<List<ExpenseConcept>> execute(GetAllExpenseConceptQuery query) {
        return repository.findAllPaginated(GetAllExpenseConceptMapper.toFilter(query));
    }
}
