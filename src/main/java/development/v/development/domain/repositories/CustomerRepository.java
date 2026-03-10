package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.Customer;
import development.v.development.domain.responses.PaginatedResultDto;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<Customer> findById(Long cliId);
    PaginatedResultDto<List<Customer>> findAllPaginated(EntityFilter filter);

    boolean existsByCustNumDocument(String cliNumDocumento);
    boolean existsByCustCorreo(String cliCorreo);
}
