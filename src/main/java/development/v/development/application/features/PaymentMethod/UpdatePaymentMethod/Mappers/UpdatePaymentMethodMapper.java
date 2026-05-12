package development.v.development.application.features.PaymentMethod.UpdatePaymentMethod.Mappers;

import development.v.development.application.features.PaymentMethod.UpdatePaymentMethod.Dtos.UpdatePaymentMethodRequest;
import development.v.development.domain.models.PaymentMethod;

public class UpdatePaymentMethodMapper {
    public static PaymentMethod toDomain(Long id, UpdatePaymentMethodRequest request) {
        PaymentMethod model = new PaymentMethod();
        model.setFpId(id);
        model.setFpDescripcion(request.getFpDescripcion());
        model.setFpEstado(request.getFpEstado());
        return model;
    }
}
