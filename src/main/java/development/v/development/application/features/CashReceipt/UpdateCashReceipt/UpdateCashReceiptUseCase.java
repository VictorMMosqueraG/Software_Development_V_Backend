package development.v.development.application.features.CashReceipt.UpdateCashReceipt;

import org.springframework.stereotype.Service;

import development.v.development.application.features.CashReceipt.UpdateCashReceipt.Dtos.UpdateCashReceiptRequest;
import development.v.development.application.features.CashReceipt.UpdateCashReceipt.Mappers.UpdateCashReceiptMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.CashReceipt;
import development.v.development.domain.repositories.CashReceiptRepository;
import development.v.development.domain.repositories.CustomerRepository;
import development.v.development.domain.repositories.OrderRepository;
import development.v.development.domain.repositories.UserRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateCashReceiptUseCase {

    private final CashReceiptRepository cashReceiptRepository;
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public UpdateCashReceiptUseCase(
            CashReceiptRepository cashReceiptRepository,
            UserRepository userRepository,
            CustomerRepository customerRepository,
            OrderRepository orderRepository) {
        this.cashReceiptRepository = cashReceiptRepository;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    public DataResultDto<CashReceipt> execute(Long id, UpdateCashReceiptRequest request) {

        validateRequest(id, request);

        CashReceipt domain = UpdateCashReceiptMapper.toDomain(id, request);
        CashReceipt updated = cashReceiptRepository.update(domain);

        return DataResultDto.success(updated, Message.SUCCESS);
    }

    private void validateRequest(Long id, UpdateCashReceiptRequest request) {
        cashReceiptRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        userRepository.findById(request.getUsuId())
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND + ": Usuario " + request.getUsuId()));

        if (request.getCliId() != null) {
            customerRepository.findById(request.getCliId())
                    .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND + ": Cliente " + request.getCliId()));
        }

        orderRepository.findById(request.getPedId())
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND + ": Pedido " + request.getPedId()));
    }
}
