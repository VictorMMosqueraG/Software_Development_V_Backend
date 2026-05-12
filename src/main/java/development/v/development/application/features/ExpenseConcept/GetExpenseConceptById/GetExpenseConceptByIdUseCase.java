package development.v.development.application.features.ExpenseConcept.GetExpenseConceptById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.ExpenseConcept;
import development.v.development.domain.repositories.ExpenseConceptRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetExpenseConceptByIdUseCase {
    private final ExpenseConceptRepository repository;

    public GetExpenseConceptByIdUseCase(ExpenseConceptRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<ExpenseConcept> execute(Long id) {
        ExpenseConcept model = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
        return DataResultDto.success(model, Message.SUCCESS);
    }
}
