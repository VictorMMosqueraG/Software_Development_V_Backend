package development.v.development.application.features.Order.GetAllOrder;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Order.GetAllOrder.Dtos.GetAllOrderQuery;
import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.Order;
import development.v.development.domain.repositories.OrderRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllOrderUseCase {

    private final OrderRepository orderRepository;

    public GetAllOrderUseCase(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public PaginatedResultDto<List<Order>> execute(GetAllOrderQuery query) {
        EntityFilter filter = new EntityFilter(query)
                .addFilter("usuId", query.getUsuId())
                .addFilter("pedMesa", query.getPedMesa())
                .addFilter("estId", query.getEstId());

        return orderRepository.findAllPaginated(filter);
    }
}

