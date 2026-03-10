package development.v.development.application.features.Customer.CreateCustomer;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Customer.CreateCustomer.Dtos.CreateCustomerRequestDto;
import development.v.development.application.features.Customer.CreateCustomer.Mappers.CreateCustomerMapper;
import development.v.development.domain.exceptions.ConflictException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Customer;
import development.v.development.domain.repositories.CustomerRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateCustomerUseCase {

    private final CustomerRepository customerRepository;

    public CreateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public DataResultDto<Customer> execute(CreateCustomerRequestDto request) {

        validateRequest(request.getCliNumDocumento(), request.getCliCorreo());

        Customer domain = CreateCustomerMapper.toDomain(request);
        customerRepository.save(domain);

        return DataResultDto.success(domain, Message.SUCCESS);
    }

    private void validateRequest(String CustomerDocument, String CustomerEmail) {
        if (customerRepository.existsByCustNumDocument(CustomerDocument)) {
            throw new ConflictException(Message.ALREADY_EXIST + " Número de documento");
        }

        if (customerRepository.existsByCustCorreo(CustomerEmail)) {
            throw new ConflictException(Message.ALREADY_EXIST + " Correo");
        }
    }
}
