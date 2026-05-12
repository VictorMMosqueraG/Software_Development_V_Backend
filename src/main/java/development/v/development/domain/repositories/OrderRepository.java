package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.Order;
import development.v.development.domain.responses.PaginatedResultDto;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(Long pedId);
    PaginatedResultDto<List<Order>> findAllPaginated(EntityFilter filter);
    Order update(Order order);
    void delete(Long id);
}
