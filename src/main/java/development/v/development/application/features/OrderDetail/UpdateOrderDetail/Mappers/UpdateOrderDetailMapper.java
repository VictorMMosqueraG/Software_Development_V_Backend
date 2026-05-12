package development.v.development.application.features.OrderDetail.UpdateOrderDetail.Mappers;

import development.v.development.application.features.OrderDetail.UpdateOrderDetail.Dtos.UpdateOrderDetailRequest;
import development.v.development.domain.models.OrderDetail;

public class UpdateOrderDetailMapper {

    public static OrderDetail toDomain(Long id, UpdateOrderDetailRequest request) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setPedDetId(id);
        orderDetail.setPedId(request.getPedId());
        orderDetail.setPlaId(request.getPlaId());
        orderDetail.setPedDetCant(request.getPedDetCant());
        orderDetail.setPedDetPrecio(request.getPedDetPrecio());
        orderDetail.setPedDetObser(request.getPedDetObser());
        orderDetail.setEstId(request.getEstId());
        return orderDetail;
    }
}
