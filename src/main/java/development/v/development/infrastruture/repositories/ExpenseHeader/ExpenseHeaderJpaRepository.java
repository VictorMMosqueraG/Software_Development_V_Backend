package development.v.development.infrastruture.repositories.ExpenseHeader;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.ExpenseHeaderEntity;

@Repository
public interface ExpenseHeaderJpaRepository extends
    JpaRepository<ExpenseHeaderEntity, Long>,
    JpaSpecificationExecutor<ExpenseHeaderEntity> {

    boolean existsByNoEgreso(Long noEgreso);
}
