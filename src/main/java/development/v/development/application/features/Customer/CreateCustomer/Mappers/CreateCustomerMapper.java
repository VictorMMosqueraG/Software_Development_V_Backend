package development.v.development.application.features.Customer.CreateCustomer.Mappers;

import development.v.development.application.features.Customer.CreateCustomer.Dtos.CreateCustomerRequestDto;
import development.v.development.domain.models.Customer;

public class CreateCustomerMapper {
    
    public static Customer toDomain(CreateCustomerRequestDto request) {
        Customer customer = new Customer();
        customer.setCliNombre(request.getCliNombre());
        customer.setCliApellidos(request.getCliApellidos());
        customer.setCliTipoDocumento(request.getCliTipoDocumento());
        customer.setCliNumDocumento(request.getCliNumDocumento());
        customer.setCliDireccion(request.getCliDireccion());
        customer.setCliTelefono(request.getCliTelefono());
        customer.setCliCorreo(request.getCliCorreo());
        customer.setCliEstado(request.getCliEstado());
        return customer;
    }
}
