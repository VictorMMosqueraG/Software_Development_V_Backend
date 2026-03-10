package development.v.development.application.features.Customer.UpdateCustomer.Mappers;

import development.v.development.application.features.Customer.UpdateCustomer.Dtos.UpdateCustomerRequest;
import development.v.development.domain.models.Customer;

public class UpdateCustomerMapper {

    public static Customer toDomain(Long id, UpdateCustomerRequest request) {
        Customer customer = new Customer();
        customer.setCliId(id);
        customer.setCliNombre(request.getCliNombre());
        customer.setCliApellidos(request.getCliApellidos());
        customer.setCliTipoDocumento(request.getCliTipoDocumento());
        customer.setCliDireccion(request.getCliDireccion());
        customer.setCliTelefono(request.getCliTelefono());
        customer.setCliEstado(request.getCliEstado());
        return customer;
    }
}
