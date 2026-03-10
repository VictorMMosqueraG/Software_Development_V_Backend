package development.v.development.infrastruture.repositories.Customer;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import development.v.development.domain.models.Customer;
import development.v.development.domain.repositories.CustomerRepository;
import development.v.development.infrastruture.entities.CustomerEntity;
import development.v.development.infrastruture.mappers.CustomerMapper;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository jpaRepository;

    public CustomerRepositoryImpl(CustomerJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entity = CustomerMapper.toEntity(customer);
        return CustomerMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return jpaRepository.findById(id)
            .map(CustomerMapper::toDomain);
    }

    @Override
    public boolean existsByCustNumDocument(String numDocumento) {
        return jpaRepository.existsByCliNumDocumento(numDocumento);
    }

    @Override
    public boolean existsByCustCorreo(String correo) {
        return jpaRepository.existsByCliCorreo(correo);
    }
}
