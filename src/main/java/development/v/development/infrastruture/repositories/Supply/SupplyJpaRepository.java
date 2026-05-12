package development.v.development.infrastruture.repositories.Supply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.SupplyEntity;

@Repository
public interface SupplyJpaRepository extends
    JpaRepository<SupplyEntity, Long>,
    JpaSpecificationExecutor<SupplyEntity> {
}
