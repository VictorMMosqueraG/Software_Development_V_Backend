package development.v.development.application.features.CashReceiptDetail.DeleteCashReceiptDetail;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.CashReceiptDetail;
import development.v.development.domain.repositories.CashReceiptDetailRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeleteCashReceiptDetailUseCase {

    private final CashReceiptDetailRepository repository;

    public DeleteCashReceiptDetailUseCase(CashReceiptDetailRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<CashReceiptDetail> execute(Long id) {
        CashReceiptDetail found = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        repository.delete(id);
        return DataResultDto.success(found, Message.SUCCESS);
    }
}
