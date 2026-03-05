package development.v.development.infrastruture.repositories.Customer;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import development.v.development.domain.models.Customer;
import development.v.development.domain.repositories.CustomerRepository;
import development.v.development.infrastruture.mappers.CustomerMapper;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository jpaRepository;

    public CustomerRepositoryImpl(CustomerJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Customer> findById(Integer customerId) {
        return jpaRepository.findById(customerId)
                .map(CustomerMapper::toDomain);
    }
}
