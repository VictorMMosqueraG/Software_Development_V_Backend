package development.v.development.application.features.Customer.GetAllCustomer.Mappers;

import development.v.development.application.features.Customer.GetAllCustomer.Dtos.GetAllCustomerQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllCustomerMapper {
    
    public static EntityFilter toFilter(GetAllCustomerQuery query) {
        return new EntityFilter(query)
                .addFilter("cliEstado", query.getCliEstado())
                .addFilter("cliTipoDocumento", query.getCliTipoDocumento())
                .addFilter("cliNumDocumento", query.getCliNumDocumento());
    }
}
