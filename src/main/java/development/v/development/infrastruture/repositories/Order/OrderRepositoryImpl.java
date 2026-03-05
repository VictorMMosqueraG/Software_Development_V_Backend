package development.v.development.infrastruture.repositories.Order;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import development.v.development.domain.models.Order;
import development.v.development.domain.repositories.OrderRepository;
import development.v.development.infrastruture.mappers.OrderMapper;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository jpaRepository;

    public OrderRepositoryImpl(OrderJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Order> findById(Integer orderId) {
        return jpaRepository.findById(orderId)
                .map(OrderMapper::toDomain);
    }
}