package development.v.development.infrastruture.repositories.Plato;

import development.v.development.infrastruture.entities.PlatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoJpaRepository extends JpaRepository<PlatoEntity, Long> {
}
