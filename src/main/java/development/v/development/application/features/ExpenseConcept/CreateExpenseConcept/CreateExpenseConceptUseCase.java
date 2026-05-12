package development.v.development.application.features.ExpenseConcept.CreateExpenseConcept;

import org.springframework.stereotype.Service;

import development.v.development.application.features.ExpenseConcept.CreateExpenseConcept.Dtos.CreateExpenseConceptRequestDto;
import development.v.development.application.features.ExpenseConcept.CreateExpenseConcept.Mappers.CreateExpenseConceptMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.ExpenseConcept;
import development.v.development.domain.repositories.ExpenseConceptRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateExpenseConceptUseCase {

    private final ExpenseConceptRepository repository;

    public CreateExpenseConceptUseCase(ExpenseConceptRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<ExpenseConcept> execute(CreateExpenseConceptRequestDto request) {
        ExpenseConcept domain = CreateExpenseConceptMapper.toDomain(request);
        repository.save(domain);
        return DataResultDto.success(domain, Message.SUCCESS);
    }
}
