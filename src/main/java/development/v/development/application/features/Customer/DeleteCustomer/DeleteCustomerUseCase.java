package development.v.development.application.features.Customer.DeleteCustomer;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Customer;
import development.v.development.domain.repositories.CustomerRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeleteCustomerUseCase {
    
    private final CustomerRepository customerRepository;

    public DeleteCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public DataResultDto<Customer> execute(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        customerRepository.delete(id);
        return DataResultDto.success(customer,Message.SUCCESS);
    }
}
