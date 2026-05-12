package development.v.development.application.features.OrderDetail.CreateOrderDetail.Mappers;

import development.v.development.application.features.OrderDetail.CreateOrderDetail.Dtos.CreateOrderDetailRequestDto;
import development.v.development.domain.models.OrderDetail;

public class CreateOrderDetailMapper {

    public static OrderDetail toDomain(CreateOrderDetailRequestDto request) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setPedId(request.getPedId());
        orderDetail.setPlaId(request.getPlaId());
        orderDetail.setPedDetCant(request.getPedDetCant());
        orderDetail.setPedDetPrecio(request.getPedDetPrecio());
        orderDetail.setPedDetObser(request.getPedDetObser());
        orderDetail.setEstId(request.getEstId());
        return orderDetail;
    }
}
