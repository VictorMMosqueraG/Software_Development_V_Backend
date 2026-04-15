package development.v.development.infrastruture.repositories.OrderDetail;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.OrderDetailEntity;

@Repository
public interface OrderDetailJpaRepository extends 
    JpaRepository<OrderDetailEntity, Integer>,
    JpaSpecificationExecutor<OrderDetailEntity> {
    
    List<OrderDetailEntity> findByPedId(Integer pedId);
}

