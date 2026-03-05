package development.v.development.domain.repositories;

import java.util.Optional;

import development.v.development.domain.models.Order;

public interface OrderRepository {
    Optional<Order> findById(Integer pedId);
}
