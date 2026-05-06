package development.v.development.application.features.CashReceiptDetail.UpdateCashReceiptDetail;

import org.springframework.stereotype.Service;

import development.v.development.application.features.CashReceiptDetail.UpdateCashReceiptDetail.Dtos.UpdateCashReceiptDetailRequest;
import development.v.development.application.features.CashReceiptDetail.UpdateCashReceiptDetail.Mappers.UpdateCashReceiptDetailMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.CashReceiptDetail;
import development.v.development.domain.repositories.CashReceiptDetailRepository;
import development.v.development.domain.repositories.CashReceiptRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateCashReceiptDetailUseCase {

    private final CashReceiptDetailRepository repository;
    private final CashReceiptRepository cashReceiptRepository;

    public UpdateCashReceiptDetailUseCase(
            CashReceiptDetailRepository repository,
            CashReceiptRepository cashReceiptRepository) {
        this.repository = repository;
        this.cashReceiptRepository = cashReceiptRepository;
    }

    public DataResultDto<CashReceiptDetail> execute(Long id, UpdateCashReceiptDetailRequest request) {

        validateRequest(id, request);

        CashReceiptDetail domain = UpdateCashReceiptDetailMapper.toDomain(id, request);
        CashReceiptDetail updated = repository.update(domain);

        return DataResultDto.success(updated, Message.SUCCESS);
    }

    private void validateRequest(Long id, UpdateCashReceiptDetailRequest request) {
        repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        cashReceiptRepository.findById(request.getRcNum())
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND + ": Recibo de caja " + request.getRcNum()));
    }
}
