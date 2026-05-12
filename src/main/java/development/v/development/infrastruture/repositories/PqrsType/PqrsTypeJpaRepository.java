package development.v.development.infrastruture.repositories.PqrsType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.PqrsTypeEntity;

@Repository
public interface PqrsTypeJpaRepository extends
    JpaRepository<PqrsTypeEntity, Long>,
    JpaSpecificationExecutor<PqrsTypeEntity> {
}
