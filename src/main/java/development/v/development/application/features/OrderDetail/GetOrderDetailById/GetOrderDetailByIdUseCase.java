package development.v.development.application.features.OrderDetail.GetOrderDetailById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.OrderDetail;
import development.v.development.domain.repositories.OrderDetailRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetOrderDetailByIdUseCase {

    private final OrderDetailRepository orderDetailRepository;

    public GetOrderDetailByIdUseCase(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public DataResultDto<OrderDetail> execute(Long id) {
        OrderDetail orderDetail = orderDetailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        return DataResultDto.success(orderDetail, Message.SUCCESS);
    }
}
