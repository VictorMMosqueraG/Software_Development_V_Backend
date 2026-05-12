package development.v.development.infrastruture.repositories.PaymentMethod;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.PaymentMethodEntity;

@Repository
public interface PaymentMethodJpaRepository extends
    JpaRepository<PaymentMethodEntity, Long>,
    JpaSpecificationExecutor<PaymentMethodEntity> {
}
