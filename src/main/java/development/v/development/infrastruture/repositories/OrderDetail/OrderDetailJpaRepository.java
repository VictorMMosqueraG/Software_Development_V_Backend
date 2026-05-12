package development.v.development.infrastruture.repositories.OrderDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.OrderDetailEntity;

@Repository
public interface OrderDetailJpaRepository extends
    JpaRepository<OrderDetailEntity, Long>,
    JpaSpecificationExecutor<OrderDetailEntity> {
}
