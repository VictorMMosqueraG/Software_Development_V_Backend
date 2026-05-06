package development.v.development.application.features.CashReceipt.DeleteCashReceipt;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.CashReceipt;
import development.v.development.domain.repositories.CashReceiptRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeleteCashReceiptUseCase {
    private final CashReceiptRepository cashReceiptRepository;

    public DeleteCashReceiptUseCase(CashReceiptRepository cashReceiptRepository) {
        this.cashReceiptRepository = cashReceiptRepository;
    }

    public DataResultDto<CashReceipt> execute(Long id) {
        CashReceipt foundCashReceipt = cashReceiptRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        cashReceiptRepository.delete(id);
        return DataResultDto.success(foundCashReceipt, Message.SUCCESS);
    }
}
