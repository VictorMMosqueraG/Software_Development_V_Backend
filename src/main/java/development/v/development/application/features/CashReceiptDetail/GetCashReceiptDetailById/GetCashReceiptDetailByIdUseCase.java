package development.v.development.application.features.CashReceiptDetail.GetCashReceiptDetailById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.CashReceiptDetail;
import development.v.development.domain.repositories.CashReceiptDetailRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetCashReceiptDetailByIdUseCase {

    private final CashReceiptDetailRepository repository;

    public GetCashReceiptDetailByIdUseCase(CashReceiptDetailRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<CashReceiptDetail> execute(Long id) {
        CashReceiptDetail detail = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        return DataResultDto.success(detail, Message.SUCCESS);
    }
}
