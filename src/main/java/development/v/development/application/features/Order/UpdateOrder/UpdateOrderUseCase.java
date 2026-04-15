package development.v.development.application.features.Order.UpdateOrder;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Order.UpdateOrder.Dtos.UpdateOrderRequestDto;
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

    public DataResultDto<Order> execute(Integer id, UpdateOrderRequestDto request) {
        Order existing = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND + " Pedido con ID: " + id));

        if (request.getPedFecha() != null) {
            existing.setPedFecha(request.getPedFecha());
        }
        if (request.getUsuId() != null) {
            existing.setUsuId(request.getUsuId());
        }
        if (request.getPedMesa() != null) {
            existing.setPedMesa(request.getPedMesa());
        }
        if (request.getEstId() != null) {
            existing.setEstId(request.getEstId());
        }

        Order updated = orderRepository.update(existing);
        return DataResultDto.success(updated, Message.SUCCESS);
    }
}

