package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.OrderDetail;
import development.v.development.domain.responses.PaginatedResultDto;

public interface OrderDetailRepository {
    OrderDetail save(OrderDetail orderDetail);
    Optional<OrderDetail> findById(Long pedDetId);
    PaginatedResultDto<List<OrderDetail>> findAllPaginated(EntityFilter filter);
    OrderDetail update(OrderDetail orderDetail);
    void delete(Long id);
}
