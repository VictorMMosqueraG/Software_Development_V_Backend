package development.v.development.infrastruture.repositories.CashReceipt;

import development.v.development.infrastruture.entities.CashReceiptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor; 
import org.springframework.stereotype.Repository;

@Repository
public interface CashReceipJpaRepository extends JpaRepository<CashReceiptEntity, Integer>,
        JpaSpecificationExecutor<CashReceiptEntity> { 
}