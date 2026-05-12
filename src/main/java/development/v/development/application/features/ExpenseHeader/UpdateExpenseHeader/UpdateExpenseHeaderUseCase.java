package development.v.development.application.features.ExpenseHeader.UpdateExpenseHeader;

import org.springframework.stereotype.Service;

import development.v.development.application.features.ExpenseHeader.UpdateExpenseHeader.Dtos.UpdateExpenseHeaderRequest;
import development.v.development.application.features.ExpenseHeader.UpdateExpenseHeader.Mappers.UpdateExpenseHeaderMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.ExpenseHeader;
import development.v.development.domain.repositories.ExpenseHeaderRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateExpenseHeaderUseCase {
    private final ExpenseHeaderRepository repository;

    public UpdateExpenseHeaderUseCase(ExpenseHeaderRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<ExpenseHeader> execute(Long id, UpdateExpenseHeaderRequest request) {
        repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        ExpenseHeader domain = UpdateExpenseHeaderMapper.toDomain(id, request);
        ExpenseHeader updated = repository.update(domain);
        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
