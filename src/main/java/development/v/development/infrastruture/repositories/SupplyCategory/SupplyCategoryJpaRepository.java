package development.v.development.infrastruture.repositories.SupplyCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.SupplyCategoryEntity;

@Repository
public interface SupplyCategoryJpaRepository extends
    JpaRepository<SupplyCategoryEntity, Long>,
    JpaSpecificationExecutor<SupplyCategoryEntity> {
}
