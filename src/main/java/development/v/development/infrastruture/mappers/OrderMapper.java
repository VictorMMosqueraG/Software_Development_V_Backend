package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.Order;
import development.v.development.infrastruture.entities.OrderEntity;

public class OrderMapper {
    
    public static Order toDomain(OrderEntity entity) {
        Order model = new Order();
        model.setPedId(entity.getPedId());
        model.setPedMesa(entity.getPedMesa());
        return model;
    }

}
