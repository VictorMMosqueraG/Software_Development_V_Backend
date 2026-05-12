package development.v.development.infrastruture.repositories.DishCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.DishCategoryEntity;

@Repository
public interface DishCategoryJpaRepository extends
    JpaRepository<DishCategoryEntity, Long>,
    JpaSpecificationExecutor<DishCategoryEntity> {
}
