package development.v.development.application.features.ExpenseHeader.GetExpenseHeaderById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.ExpenseHeader;
import development.v.development.domain.repositories.ExpenseHeaderRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetExpenseHeaderByIdUseCase {
    private final ExpenseHeaderRepository repository;

    public GetExpenseHeaderByIdUseCase(ExpenseHeaderRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<ExpenseHeader> execute(Long id) {
        ExpenseHeader model = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
        return DataResultDto.success(model, Message.SUCCESS);
    }
}
