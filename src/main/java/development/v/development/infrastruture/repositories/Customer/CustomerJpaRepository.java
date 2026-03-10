package development.v.development.infrastruture.repositories.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import development.v.development.infrastruture.entities.CustomerEntity;

@Repository
public interface CustomerJpaRepository extends 
    JpaRepository<CustomerEntity, Long>,
    JpaSpecificationExecutor<CustomerEntity> {

    boolean existsByCliNumDocumento(String cliNumDocumento);
    boolean existsByCliCorreo(String cliCorreo);
}
