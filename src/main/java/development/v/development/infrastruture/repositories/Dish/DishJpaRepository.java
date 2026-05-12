package development.v.development.infrastruture.repositories.Dish;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.DishEntity;

@Repository
public interface DishJpaRepository extends
    JpaRepository<DishEntity, Long>,
    JpaSpecificationExecutor<DishEntity> {
}
