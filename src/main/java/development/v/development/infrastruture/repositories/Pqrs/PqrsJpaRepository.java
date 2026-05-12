package development.v.development.infrastruture.repositories.Pqrs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.PqrsEntity;

@Repository
public interface PqrsJpaRepository extends
    JpaRepository<PqrsEntity, Long>,
    JpaSpecificationExecutor<PqrsEntity> {
}
