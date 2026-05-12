package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.OrderDetail;
import development.v.development.infrastruture.entities.OrderDetailEntity;

public class OrderDetailMapper {

    public static OrderDetail toDomain(OrderDetailEntity entity) {
        OrderDetail model = new OrderDetail();
        model.setPedDetId(entity.getPedDetId());
        model.setPedId(entity.getPedId());
        model.setPlaId(entity.getPlaId());
        model.setPedDetCant(entity.getPedDetCant());
        model.setPedDetPrecio(entity.getPedDetPrecio());
        model.setPedDetObser(entity.getPedDetObser());
        model.setEstId(entity.getEstId());
        model.setCreatedAt(entity.getCreatedAt());
        model.setUpdatedAt(entity.getUpdatedAt());
        return model;
    }

    public static OrderDetailEntity toEntity(OrderDetail model) {
        OrderDetailEntity entity = new OrderDetailEntity();
        entity.setPedDetId(model.getPedDetId());
        entity.setPedId(model.getPedId());
        entity.setPlaId(model.getPlaId());
        entity.setPedDetCant(model.getPedDetCant());
        entity.setPedDetPrecio(model.getPedDetPrecio());
        entity.setPedDetObser(model.getPedDetObser());
        entity.setEstId(model.getEstId());
        return entity;
    }
}
