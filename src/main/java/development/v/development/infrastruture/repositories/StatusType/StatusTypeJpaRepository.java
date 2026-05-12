package development.v.development.infrastruture.repositories.StatusType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.StatusTypeEntity;

@Repository
public interface StatusTypeJpaRepository extends
    JpaRepository<StatusTypeEntity, Long>,
    JpaSpecificationExecutor<StatusTypeEntity> {
}
