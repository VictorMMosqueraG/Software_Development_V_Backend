package development.v.development.application.features.PaymentMethod.GetAllPaymentMethod.Mappers;

import development.v.development.application.features.PaymentMethod.GetAllPaymentMethod.Dtos.GetAllPaymentMethodQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllPaymentMethodMapper {
    public static EntityFilter toFilter(GetAllPaymentMethodQuery query) {
        return new EntityFilter(query)
                .addFilter("fpEstado", query.getFpEstado());
    }
}
