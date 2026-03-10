package development.v.development.domain.repositories;

import java.util.Optional;

import development.v.development.domain.models.Customer;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(Long cliId);
    boolean existsByCustNumDocument(String cliNumDocumento);
    boolean existsByCustCorreo(String cliCorreo);
}
