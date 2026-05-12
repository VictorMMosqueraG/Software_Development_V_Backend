package development.v.development.application.features.OrderDetail.CreateOrderDetail;

import org.springframework.stereotype.Service;

import development.v.development.application.features.OrderDetail.CreateOrderDetail.Dtos.CreateOrderDetailRequestDto;
import development.v.development.application.features.OrderDetail.CreateOrderDetail.Mappers.CreateOrderDetailMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.OrderDetail;
import development.v.development.domain.repositories.OrderDetailRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateOrderDetailUseCase {

    private final OrderDetailRepository orderDetailRepository;

    public CreateOrderDetailUseCase(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public DataResultDto<OrderDetail> execute(CreateOrderDetailRequestDto request) {
        OrderDetail domain = CreateOrderDetailMapper.toDomain(request);
        OrderDetail saved = orderDetailRepository.save(domain);
        return DataResultDto.success(saved, Message.SUCCESS);
    }
}
