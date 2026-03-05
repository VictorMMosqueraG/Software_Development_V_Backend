package development.v.development.domain.repositories;

import java.util.Optional;

import development.v.development.domain.models.Customer;

public interface CustomerRepository {
    Optional<Customer> findById(Integer cliId);
}
