package development.v.development.application.features.Order.CreateOrder.Mappers;

import development.v.development.application.features.Order.CreateOrder.Dtos.CreateOrderRequestDto;
import development.v.development.domain.models.Order;

import java.time.LocalDate;

public class CreateOrderMapper {

    public static Order toDomain(CreateOrderRequestDto dto) {
        Order order = new Order();
        order.setPedFecha(dto.getPedFecha() != null ? dto.getPedFecha() : LocalDate.now());
        order.setUsuId(dto.getUsuId());
        order.setPedMesa(dto.getPedMesa());
        order.setEstId(dto.getEstId());
        return order;
    }
}

