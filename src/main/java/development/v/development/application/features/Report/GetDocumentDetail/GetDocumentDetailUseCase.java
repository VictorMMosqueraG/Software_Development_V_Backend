package development.v.development.application.features.Report.GetDocumentDetail;

import java.util.Optional;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.CashReceipt;
import development.v.development.domain.models.Order;
import development.v.development.domain.repositories.CashReceiptRepository;
import development.v.development.domain.repositories.OrderRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetDocumentDetailUseCase {

    private final OrderRepository orderRepository;
    private final CashReceiptRepository cashReceiptRepository;

    public GetDocumentDetailUseCase(OrderRepository orderRepository,
                                    CashReceiptRepository cashReceiptRepository) {
        this.orderRepository = orderRepository;
        this.cashReceiptRepository = cashReceiptRepository;
    }

    public DataResultDto<Order> getOrderDetail(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            throw new NotFoundException(Message.NOT_FOUND);
        }
        return DataResultDto.success(order.get(), Message.SUCCESS);
    }

    public DataResultDto<CashReceipt> getCashReceiptDetail(Long id) {
        Optional<CashReceipt> receipt = cashReceiptRepository.findById(id);
        if (receipt.isEmpty()) {
            throw new NotFoundException(Message.NOT_FOUND);
        }
        return DataResultDto.success(receipt.get(), Message.SUCCESS);
    }
}
