package development.v.development.application.features.Customer.GetAllCustomer;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Customer.GetAllCustomer.Dtos.GetAllCustomerQuery;
import development.v.development.application.features.Customer.GetAllCustomer.Mappers.GetAllCustomerMapper;
import development.v.development.domain.models.Customer;
import development.v.development.domain.repositories.CustomerRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllCustomerUseCase {

    private final CustomerRepository repository;

    public GetAllCustomerUseCase(CustomerRepository customerRepository) {
        this.repository = customerRepository;
    }

    public PaginatedResultDto<List<Customer>> execute(GetAllCustomerQuery query) {
        return repository.findAllPaginated(GetAllCustomerMapper.toFilter(query));
    }
}
