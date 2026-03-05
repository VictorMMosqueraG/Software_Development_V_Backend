package development.v.development.application.cases.CashReceipt.CreateCashReceipt;

import development.v.development.application.cases.CashReceipt.CreateCashReceipt.Dtos.CreateCashReceiptRequest;
import development.v.development.application.cases.CashReceipt.CreateCashReceipt.Mappers.CreateCashReceiptMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.CashReceipt;
import development.v.development.domain.repositories.CashReceiptRepository;
import development.v.development.domain.repositories.CustomerRepository;
import development.v.development.domain.repositories.OrderRepository;
import development.v.development.domain.repositories.UserRepository;
import development.v.development.domain.responses.DataResultDto;
import org.springframework.stereotype.Service;

@Service
public class CreateCashReceiptUseCase {
   
    private final CashReceiptRepository repository;
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public CreateCashReceiptUseCase(
            CashReceiptRepository repository,
            UserRepository userRepository,
            CustomerRepository customerRepository,
            OrderRepository orderRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    public DataResultDto<CashReceipt> execute(CreateCashReceiptRequest request) {

       validateRequest(request);

        CashReceipt saved = repository.save(CreateCashReceiptMapper.RequestToDomain(request));
        return DataResultDto.success(saved, Message.CREATED);
    }

    private void validateRequest(CreateCashReceiptRequest request) {
        userRepository.findById(request.getUsuId())
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND + ": Usuario " + request.getUsuId()));

        customerRepository.findById(request.getCliId())
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND + ": Cliente " + request.getCliId()));

        orderRepository.findById(request.getPedId())
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND + ": Pedido " + request.getPedId()));
    }
}
