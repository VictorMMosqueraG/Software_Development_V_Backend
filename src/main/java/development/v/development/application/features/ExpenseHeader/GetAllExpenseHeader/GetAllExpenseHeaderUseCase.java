package development.v.development.application.features.ExpenseHeader.GetAllExpenseHeader;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.ExpenseHeader.GetAllExpenseHeader.Dtos.GetAllExpenseHeaderQuery;
import development.v.development.application.features.ExpenseHeader.GetAllExpenseHeader.Mappers.GetAllExpenseHeaderMapper;
import development.v.development.domain.models.ExpenseHeader;
import development.v.development.domain.repositories.ExpenseHeaderRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllExpenseHeaderUseCase {

    private final ExpenseHeaderRepository repository;

    public GetAllExpenseHeaderUseCase(ExpenseHeaderRepository repository) {
        this.repository = repository;
    }

    public PaginatedResultDto<List<ExpenseHeader>> execute(GetAllExpenseHeaderQuery query) {
        return repository.findAllPaginated(GetAllExpenseHeaderMapper.toFilter(query));
    }
}
