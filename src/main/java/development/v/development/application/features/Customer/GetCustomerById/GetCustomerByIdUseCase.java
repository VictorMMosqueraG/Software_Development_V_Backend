package development.v.development.application.features.Customer.GetCustomerById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Customer;
import development.v.development.domain.repositories.CustomerRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetCustomerByIdUseCase {
    private final CustomerRepository customerRepository;

    public GetCustomerByIdUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public DataResultDto<Customer> execute(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        return DataResultDto.success(
                customer,
                Message.SUCCESS);
    }
}
