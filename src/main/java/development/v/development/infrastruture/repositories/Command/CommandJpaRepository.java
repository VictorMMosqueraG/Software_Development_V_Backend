package development.v.development.infrastruture.repositories.Command;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.CommandEntity;

@Repository
public interface CommandJpaRepository extends 
    JpaRepository<CommandEntity, Integer>,
    JpaSpecificationExecutor<CommandEntity> {
}

