package development.v.development.infrastruture.repositories.ExpenseConcept;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.ExpenseConceptEntity;

@Repository
public interface ExpenseConceptJpaRepository extends
    JpaRepository<ExpenseConceptEntity, Long>,
    JpaSpecificationExecutor<ExpenseConceptEntity> {
}
