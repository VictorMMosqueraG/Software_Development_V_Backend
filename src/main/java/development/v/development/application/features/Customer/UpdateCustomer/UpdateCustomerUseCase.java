package development.v.development.application.features.Customer.UpdateCustomer;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Customer.UpdateCustomer.Dtos.UpdateCustomerRequest;
import development.v.development.application.features.Customer.UpdateCustomer.Mappers.UpdateCustomerMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Customer;
import development.v.development.domain.repositories.CustomerRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateCustomerUseCase {
    private final CustomerRepository customerRepository;

    public UpdateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public DataResultDto<Customer> execute(Long id, UpdateCustomerRequest request) {

        customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        Customer domain = UpdateCustomerMapper.toDomain(id, request);
        Customer updatedCustomer = customerRepository.update(domain);

        return DataResultDto.success(
                updatedCustomer,
                Message.SUCCESS);
    }

}
