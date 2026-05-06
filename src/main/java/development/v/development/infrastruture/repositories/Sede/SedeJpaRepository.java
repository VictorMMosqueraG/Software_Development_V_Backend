package development.v.development.infrastruture.repositories.Sede;

import development.v.development.infrastruture.entities.SedeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedeJpaRepository extends JpaRepository<SedeEntity, Long> {
}
