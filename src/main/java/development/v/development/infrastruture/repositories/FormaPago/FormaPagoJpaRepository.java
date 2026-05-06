package development.v.development.infrastruture.repositories.FormaPago;

import development.v.development.infrastruture.entities.FormaPagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagoJpaRepository extends JpaRepository<FormaPagoEntity, Long> {
}
