package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.Customer;
import development.v.development.infrastruture.entities.CustomerEntity;
import development.v.development.infrastruture.enums.CustomerStatus;

public class CustomerMapper {
    public static Customer toDomain(CustomerEntity entity) {
        Customer customer = new Customer();
        customer.setCliId(entity.getCliId());
        customer.setCliNombre(entity.getCliNombre());
        customer.setCliApellidos(entity.getCliApellidos());
        customer.setCliTipoDocumento(entity.getCliTipoDocumento());
        customer.setCliNumDocumento(entity.getCliNumDocumento());
        customer.setCliDireccion(entity.getCliDireccion());
        customer.setCliTelefono(entity.getCliTelefono());
        customer.setCliCorreo(entity.getCliCorreo());
        customer.setCliEstado(entity.getCliEstado() != null
                ? entity.getCliEstado().name() : null);
        customer.setCreatedAt(entity.getCreatedAt());
        customer.setUpdatedAt(entity.getUpdatedAt());
        return customer;
    }

    public static CustomerEntity toEntity(Customer customer) {
        CustomerEntity entity = new CustomerEntity();
        entity.setCliId(customer.getCliId());
        entity.setCliNombre(customer.getCliNombre());
        entity.setCliApellidos(customer.getCliApellidos());
        entity.setCliTipoDocumento(customer.getCliTipoDocumento());
        entity.setCliNumDocumento(customer.getCliNumDocumento());
        entity.setCliDireccion(customer.getCliDireccion());
        entity.setCliTelefono(customer.getCliTelefono());
        entity.setCliCorreo(customer.getCliCorreo());
        if (customer.getCliEstado() != null) {
            entity.setCliEstado(CustomerStatus
                    .valueOf(customer.getCliEstado()));
        }
        return entity;
    }
    
}
