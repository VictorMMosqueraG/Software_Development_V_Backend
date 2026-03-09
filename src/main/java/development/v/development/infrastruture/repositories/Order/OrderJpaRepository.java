package development.v.development.infrastruture.repositories.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.OrderEntity;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, Integer>{
    
}
