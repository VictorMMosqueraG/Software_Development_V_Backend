package development.v.development.infrastruture.repositories.DiningArea;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.DiningAreaEntity;

@Repository
public interface DiningAreaJpaRepository extends
    JpaRepository<DiningAreaEntity, Long>,
    JpaSpecificationExecutor<DiningAreaEntity> {
}
