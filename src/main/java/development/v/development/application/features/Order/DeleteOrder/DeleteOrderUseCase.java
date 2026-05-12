package development.v.development.application.features.Order.DeleteOrder;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Order;
import development.v.development.domain.repositories.OrderRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeleteOrderUseCase {

    private final OrderRepository orderRepository;

    public DeleteOrderUseCase(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public DataResultDto<Order> execute(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        orderRepository.delete(id);
        return DataResultDto.success(order, Message.SUCCESS);
    }
}
