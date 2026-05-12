package development.v.development.application.features.Order.GetOrderById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Order;
import development.v.development.domain.repositories.OrderRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetOrderByIdUseCase {

    private final OrderRepository orderRepository;

    public GetOrderByIdUseCase(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public DataResultDto<Order> execute(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        return DataResultDto.success(order, Message.SUCCESS);
    }
}
