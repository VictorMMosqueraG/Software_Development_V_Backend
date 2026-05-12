package development.v.development.infrastruture.repositories.Presentation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.PresentationEntity;

@Repository
public interface PresentationJpaRepository extends
    JpaRepository<PresentationEntity, Long>,
    JpaSpecificationExecutor<PresentationEntity> {
}
