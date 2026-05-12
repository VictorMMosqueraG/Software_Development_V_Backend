package development.v.development.application.features.OrderDetail.DeleteOrderDetail;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.OrderDetail;
import development.v.development.domain.repositories.OrderDetailRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeleteOrderDetailUseCase {

    private final OrderDetailRepository orderDetailRepository;

    public DeleteOrderDetailUseCase(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public DataResultDto<OrderDetail> execute(Long id) {
        OrderDetail orderDetail = orderDetailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        orderDetailRepository.delete(id);
        return DataResultDto.success(orderDetail, Message.SUCCESS);
    }
}
