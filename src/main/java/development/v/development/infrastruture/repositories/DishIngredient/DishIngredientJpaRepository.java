package development.v.development.infrastruture.repositories.DishIngredient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.DishIngredientEntity;

@Repository
public interface DishIngredientJpaRepository extends
    JpaRepository<DishIngredientEntity, Long>,
    JpaSpecificationExecutor<DishIngredientEntity> {
}
