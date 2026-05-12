package development.v.development.infrastruture.repositories.DiningTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.DiningTableEntity;

@Repository
public interface DiningTableJpaRepository extends
    JpaRepository<DiningTableEntity, Long>,
    JpaSpecificationExecutor<DiningTableEntity> {
}
