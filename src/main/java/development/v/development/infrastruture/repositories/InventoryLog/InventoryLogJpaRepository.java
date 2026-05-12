package development.v.development.infrastruture.repositories.InventoryLog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.InventoryLogEntity;

@Repository
public interface InventoryLogJpaRepository extends
    JpaRepository<InventoryLogEntity, Long>,
    JpaSpecificationExecutor<InventoryLogEntity> {
}
