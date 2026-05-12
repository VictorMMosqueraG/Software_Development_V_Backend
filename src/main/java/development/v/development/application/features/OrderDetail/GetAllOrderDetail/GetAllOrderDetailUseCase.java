package development.v.development.application.features.OrderDetail.GetAllOrderDetail;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.OrderDetail.GetAllOrderDetail.Dtos.GetAllOrderDetailQuery;
import development.v.development.application.features.OrderDetail.GetAllOrderDetail.Mappers.GetAllOrderDetailMapper;
import development.v.development.domain.models.OrderDetail;
import development.v.development.domain.repositories.OrderDetailRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllOrderDetailUseCase {

    private final OrderDetailRepository repository;

    public GetAllOrderDetailUseCase(OrderDetailRepository orderDetailRepository) {
        this.repository = orderDetailRepository;
    }

    public PaginatedResultDto<List<OrderDetail>> execute(GetAllOrderDetailQuery query) {
        return repository.findAllPaginated(GetAllOrderDetailMapper.toFilter(query));
    }
}
