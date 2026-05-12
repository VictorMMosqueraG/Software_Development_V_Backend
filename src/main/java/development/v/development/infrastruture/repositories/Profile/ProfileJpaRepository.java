package development.v.development.infrastruture.repositories.Profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.ProfileEntity;

@Repository
public interface ProfileJpaRepository extends
    JpaRepository<ProfileEntity, Long>,
    JpaSpecificationExecutor<ProfileEntity> {

    boolean existsByPerfDescripcion(String perfDescripcion);
}
