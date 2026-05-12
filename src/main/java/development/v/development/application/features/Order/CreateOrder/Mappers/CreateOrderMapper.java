package development.v.development.application.features.Order.CreateOrder.Mappers;

import development.v.development.application.features.Order.CreateOrder.Dtos.CreateOrderRequestDto;
import development.v.development.domain.models.Order;

public class CreateOrderMapper {

    public static Order toDomain(CreateOrderRequestDto request) {
        Order order = new Order();
        order.setSedeId(request.getSedeId());
        order.setPedFecha(request.getPedFecha());
        order.setUsuId(request.getUsuId());
        order.setMesaId(request.getMesaId());
        order.setEstId(request.getEstId());
        order.setPedObs(request.getPedObs());
        return order;
    }
}
