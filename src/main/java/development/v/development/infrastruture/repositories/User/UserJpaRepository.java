package development.v.development.infrastruture.repositories.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.UserEntity;

@Repository
public interface UserJpaRepository extends
    JpaRepository<UserEntity, Long>,
    JpaSpecificationExecutor<UserEntity> {

    boolean existsByUsuCorreo(String usuCorreo);
    boolean existsByUsuLogin(String usuLogin);
}
