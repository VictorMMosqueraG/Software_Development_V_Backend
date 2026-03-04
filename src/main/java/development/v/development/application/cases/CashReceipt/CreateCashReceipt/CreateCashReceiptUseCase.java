package development.v.development.application.cases.CashReceipt.CreateCashReceipt;

import development.v.development.application.cases.CashReceipt.CreateCashReceipt.Dtos.CreateCashReceiptRequest;
import development.v.development.application.cases.CashReceipt.CreateCashReceipt.Mappers.CreateCashReceiptMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.CashReceipt;
import development.v.development.domain.repositories.CashReceiptRepository;
import development.v.development.domain.responses.DataResultDto;
import org.springframework.stereotype.Service;

@Service
public class CreateCashReceiptUseCase {
    private final CashReceiptRepository repository;

    public CreateCashReceiptUseCase(CashReceiptRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<CashReceipt> execute(CreateCashReceiptRequest request) {
        //FIX: Valid if each id exist or not
        CashReceipt saved = repository.save(CreateCashReceiptMapper.RequestToDomain(request));
        return DataResultDto.success(saved, Message.CREATED);
    }
}
