package development.v.development.application.features.Order.CreateOrder;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Order.CreateOrder.Dtos.CreateOrderRequestDto;
import development.v.development.application.features.Order.CreateOrder.Mappers.CreateOrderMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Order;
import development.v.development.domain.repositories.OrderRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateOrderUseCase {

    private final OrderRepository orderRepository;

    public CreateOrderUseCase(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public DataResultDto<Order> execute(CreateOrderRequestDto request) {
        Order domain = CreateOrderMapper.toDomain(request);
        Order saved = orderRepository.save(domain);
        return DataResultDto.success(saved, Message.SUCCESS);
    }
}
