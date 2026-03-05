package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.Customer;
import development.v.development.infrastruture.entities.CustomerEntity;

public class CustomerMapper {
    
    public static Customer toDomain(CustomerEntity entity) {
        Customer model = new Customer();
        model.setCliId(entity.getCliId());
        model.setCliNombre(entity.getCliNombre());
        return model;
    }
}
