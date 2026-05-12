package development.v.development.application.features.Order.GetAllOrder;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Order.GetAllOrder.Dtos.GetAllOrderQuery;
import development.v.development.application.features.Order.GetAllOrder.Mappers.GetAllOrderMapper;
import development.v.development.domain.models.Order;
import development.v.development.domain.repositories.OrderRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllOrderUseCase {

    private final OrderRepository repository;

    public GetAllOrderUseCase(OrderRepository orderRepository) {
        this.repository = orderRepository;
    }

    public PaginatedResultDto<List<Order>> execute(GetAllOrderQuery query) {
        return repository.findAllPaginated(GetAllOrderMapper.toFilter(query));
    }
}
