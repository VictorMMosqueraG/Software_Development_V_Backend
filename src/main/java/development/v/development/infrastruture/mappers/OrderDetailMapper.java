package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.OrderDetail;
import development.v.development.infrastruture.entities.OrderDetailEntity;

public class OrderDetailMapper {

    public static OrderDetail toDomain(OrderDetailEntity entity) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setPedDetId(entity.getPedDetId());
        orderDetail.setPedDetCant(entity.getPedDetCant());
        orderDetail.setPedDetPrecio(entity.getPedDetPrecio());
        orderDetail.setPedDetObser(entity.getPedDetObser());
        orderDetail.setPlaId(entity.getPlaId());
        orderDetail.setPedId(entity.getPedId());
        orderDetail.setEstId(entity.getEstId());
        return orderDetail;
    }

    public static OrderDetailEntity toEntity(OrderDetail orderDetail) {
        OrderDetailEntity entity = new OrderDetailEntity();
        entity.setPedDetId(orderDetail.getPedDetId());
        entity.setPedDetCant(orderDetail.getPedDetCant());
        entity.setPedDetPrecio(orderDetail.getPedDetPrecio());
        entity.setPedDetObser(orderDetail.getPedDetObser());
        entity.setPlaId(orderDetail.getPlaId());
        entity.setPedId(orderDetail.getPedId());
        entity.setEstId(orderDetail.getEstId());
        return entity;
    }
}

