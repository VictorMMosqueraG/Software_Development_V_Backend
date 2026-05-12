package development.v.development.infrastruture.repositories.Status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.StatusEntity;

@Repository
public interface StatusJpaRepository extends
    JpaRepository<StatusEntity, Long>,
    JpaSpecificationExecutor<StatusEntity> {
}
