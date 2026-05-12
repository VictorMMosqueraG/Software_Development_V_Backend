package development.v.development.application.features.ExpenseHeader.CreateExpenseHeader;

import org.springframework.stereotype.Service;

import development.v.development.application.features.ExpenseHeader.CreateExpenseHeader.Dtos.CreateExpenseHeaderRequestDto;
import development.v.development.application.features.ExpenseHeader.CreateExpenseHeader.Mappers.CreateExpenseHeaderMapper;
import development.v.development.domain.exceptions.ConflictException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.ExpenseHeader;
import development.v.development.domain.repositories.ExpenseHeaderRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateExpenseHeaderUseCase {

    private final ExpenseHeaderRepository repository;

    public CreateExpenseHeaderUseCase(ExpenseHeaderRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<ExpenseHeader> execute(CreateExpenseHeaderRequestDto request) {
        if (repository.existsByNoEgreso(request.getNoEgreso())) {
            throw new ConflictException(Message.ALREADY_EXIST + " Numero de egreso");
        }

        ExpenseHeader domain = CreateExpenseHeaderMapper.toDomain(request);
        repository.save(domain);
        return DataResultDto.success(domain, Message.SUCCESS);
    }
}
