package development.v.development.infrastruture.repositories.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.ReservationEntity;

@Repository
public interface ReservationJpaRepository extends
    JpaRepository<ReservationEntity, Long>,
    JpaSpecificationExecutor<ReservationEntity> {
}
