package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.Order;
import development.v.development.infrastruture.entities.OrderEntity;

public class OrderMapper {

    public static Order toDomain(OrderEntity entity) {
        Order order = new Order();
        order.setPedId(entity.getPedId());
        order.setPedFecha(entity.getPedFecha());
        order.setUsuId(entity.getUsuId());
        order.setPedMesa(entity.getPedMesa());
        order.setEstId(entity.getEstId());
        return order;
    }

    public static OrderEntity toEntity(Order order) {
        OrderEntity entity = new OrderEntity();
        entity.setPedId(order.getPedId());
        entity.setPedFecha(order.getPedFecha());
        entity.setUsuId(order.getUsuId());
        entity.setPedMesa(order.getPedMesa());
        entity.setEstId(order.getEstId());
        return entity;
    }
}
