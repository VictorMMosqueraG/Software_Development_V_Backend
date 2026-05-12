package development.v.development.application.features.OrderDetail.UpdateOrderDetail;

import org.springframework.stereotype.Service;

import development.v.development.application.features.OrderDetail.UpdateOrderDetail.Dtos.UpdateOrderDetailRequest;
import development.v.development.application.features.OrderDetail.UpdateOrderDetail.Mappers.UpdateOrderDetailMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.OrderDetail;
import development.v.development.domain.repositories.OrderDetailRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateOrderDetailUseCase {

    private final OrderDetailRepository orderDetailRepository;

    public UpdateOrderDetailUseCase(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public DataResultDto<OrderDetail> execute(Long id, UpdateOrderDetailRequest request) {
        orderDetailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        OrderDetail domain = UpdateOrderDetailMapper.toDomain(id, request);
        OrderDetail updated = orderDetailRepository.update(domain);

        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
