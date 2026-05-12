package development.v.development.infrastruture.repositories.Branch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.BranchEntity;

@Repository
public interface BranchJpaRepository extends
    JpaRepository<BranchEntity, Long>,
    JpaSpecificationExecutor<BranchEntity> {

    boolean existsBySedeNombre(String sedeNombre);
}
