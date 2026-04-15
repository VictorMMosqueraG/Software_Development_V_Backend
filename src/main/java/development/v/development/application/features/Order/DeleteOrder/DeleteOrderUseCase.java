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

    public DataResultDto<Order> execute(Integer id) {
        Order existing = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND + " Pedido con ID: " + id));

        orderRepository.delete(id);
        return DataResultDto.success(existing, Message.SUCCESS);
    }
}

