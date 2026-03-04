package development.v.development.infrastruture.repositories.CashReceipt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.CashReceiptEntity;

@Repository
public interface CashReceipJpaRepository extends JpaRepository<CashReceiptEntity, Integer> {
}