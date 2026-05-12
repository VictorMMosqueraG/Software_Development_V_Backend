package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.Order;
import development.v.development.infrastruture.entities.OrderEntity;

public class OrderMapper {

    public static Order toDomain(OrderEntity entity) {
        Order model = new Order();
        model.setPedId(entity.getPedId());
        model.setSedeId(entity.getSedeId());
        model.setPedFecha(entity.getPedFecha());
        model.setUsuId(entity.getUsuId());
        model.setMesaId(entity.getMesaId());
        model.setEstId(entity.getEstId());
        model.setPedObs(entity.getPedObs());
        model.setCreatedAt(entity.getCreatedAt());
        model.setUpdatedAt(entity.getUpdatedAt());
        return model;
    }

    public static OrderEntity toEntity(Order model) {
        OrderEntity entity = new OrderEntity();
        entity.setPedId(model.getPedId());
        entity.setSedeId(model.getSedeId());
        entity.setPedFecha(model.getPedFecha());
        entity.setUsuId(model.getUsuId());
        entity.setMesaId(model.getMesaId());
        entity.setEstId(model.getEstId());
        entity.setPedObs(model.getPedObs());
        return entity;
    }
}
