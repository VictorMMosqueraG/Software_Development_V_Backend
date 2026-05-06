package development.v.development.application.features.CashReceipt.GetCashReceiptById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.CashReceipt;
import development.v.development.domain.repositories.CashReceiptRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetCashReceiptByIdUseCase {

    private final CashReceiptRepository cashReceiptRepository;

    public GetCashReceiptByIdUseCase(CashReceiptRepository cashReceiptRepository) {
        this.cashReceiptRepository = cashReceiptRepository;
    }

    public DataResultDto<CashReceipt> execute(Long id) {
        CashReceipt cashReceipt = cashReceiptRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        return DataResultDto.success(cashReceipt, Message.SUCCESS);
    }
}
