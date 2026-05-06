package development.v.development.infrastruture.repositories.CashReceiptDetail;

import development.v.development.infrastruture.entities.CashReceiptDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CashReceiptDetailJpaRepository extends JpaRepository<CashReceiptDetailEntity, Long>,
        JpaSpecificationExecutor<CashReceiptDetailEntity> {
}
