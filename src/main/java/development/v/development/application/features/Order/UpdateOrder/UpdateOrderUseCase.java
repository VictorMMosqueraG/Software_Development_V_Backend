package development.v.development.application.features.Order.UpdateOrder;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Order.UpdateOrder.Dtos.UpdateOrderRequest;
import development.v.development.application.features.Order.UpdateOrder.Mappers.UpdateOrderMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Order;
import development.v.development.domain.repositories.OrderRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateOrderUseCase {

    private final OrderRepository orderRepository;

    public UpdateOrderUseCase(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public DataResultDto<Order> execute(Long id, UpdateOrderRequest request) {
        orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        Order domain = UpdateOrderMapper.toDomain(id, request);
        Order updated = orderRepository.update(domain);

        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
