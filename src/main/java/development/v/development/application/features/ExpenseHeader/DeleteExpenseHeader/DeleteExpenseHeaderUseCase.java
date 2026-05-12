package development.v.development.application.features.ExpenseHeader.DeleteExpenseHeader;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.ExpenseHeader;
import development.v.development.domain.repositories.ExpenseHeaderRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeleteExpenseHeaderUseCase {
    private final ExpenseHeaderRepository repository;

    public DeleteExpenseHeaderUseCase(ExpenseHeaderRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<ExpenseHeader> execute(Long id) {
        ExpenseHeader model = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
        repository.delete(id);
        return DataResultDto.success(model, Message.SUCCESS);
    }
}
