package development.v.development.application.features.Order.UpdateOrder.Mappers;

import development.v.development.application.features.Order.UpdateOrder.Dtos.UpdateOrderRequest;
import development.v.development.domain.models.Order;

public class UpdateOrderMapper {

    public static Order toDomain(Long id, UpdateOrderRequest request) {
        Order order = new Order();
        order.setPedId(id);
        order.setSedeId(request.getSedeId());
        order.setPedFecha(request.getPedFecha());
        order.setUsuId(request.getUsuId());
        order.setMesaId(request.getMesaId());
        order.setEstId(request.getEstId());
        order.setPedObs(request.getPedObs());
        return order;
    }
}
