package development.v.development.infrastruture.repositories.Configuration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.ConfigurationEntity;

@Repository
public interface ConfigurationJpaRepository extends
    JpaRepository<ConfigurationEntity, Long>,
    JpaSpecificationExecutor<ConfigurationEntity> {

    boolean existsByCfgClave(String cfgClave);
}
