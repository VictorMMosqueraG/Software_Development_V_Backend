package development.v.development.application.features.CashReceiptDetail.CreateCashReceiptDetail;

import development.v.development.application.features.CashReceiptDetail.CreateCashReceiptDetail.Dtos.CreateCashReceiptDetailRequest;
import development.v.development.application.features.CashReceiptDetail.CreateCashReceiptDetail.Mappers.CreateCashReceiptDetailMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.CashReceiptDetail;
import development.v.development.domain.repositories.CashReceiptDetailRepository;
import development.v.development.domain.repositories.CashReceiptRepository;
import development.v.development.domain.responses.DataResultDto;
import org.springframework.stereotype.Service;

@Service
public class CreateCashReceiptDetailUseCase {

    private final CashReceiptDetailRepository repository;
    private final CashReceiptRepository cashReceiptRepository;

    public CreateCashReceiptDetailUseCase(
            CashReceiptDetailRepository repository,
            CashReceiptRepository cashReceiptRepository) {
        this.repository = repository;
        this.cashReceiptRepository = cashReceiptRepository;
    }

    public DataResultDto<CashReceiptDetail> execute(CreateCashReceiptDetailRequest request) {

        validateRequest(request);

        CashReceiptDetail saved = repository.save(CreateCashReceiptDetailMapper.RequestToDomain(request));
        return DataResultDto.success(saved, Message.CREATED);
    }

    private void validateRequest(CreateCashReceiptDetailRequest request) {
        cashReceiptRepository.findById(request.getRcNum())
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND + ": Recibo de caja " + request.getRcNum()));
    }
}
