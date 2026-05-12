package development.v.development.application.features.ExpenseConcept.UpdateExpenseConcept;

import org.springframework.stereotype.Service;

import development.v.development.application.features.ExpenseConcept.UpdateExpenseConcept.Dtos.UpdateExpenseConceptRequest;
import development.v.development.application.features.ExpenseConcept.UpdateExpenseConcept.Mappers.UpdateExpenseConceptMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.ExpenseConcept;
import development.v.development.domain.repositories.ExpenseConceptRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateExpenseConceptUseCase {
    private final ExpenseConceptRepository repository;

    public UpdateExpenseConceptUseCase(ExpenseConceptRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<ExpenseConcept> execute(Long id, UpdateExpenseConceptRequest request) {
        repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        ExpenseConcept domain = UpdateExpenseConceptMapper.toDomain(id, request);
        ExpenseConcept updated = repository.update(domain);
        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
