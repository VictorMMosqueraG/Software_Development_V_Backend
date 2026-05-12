package development.v.development.application.features.PaymentMethod.CreatePaymentMethod.Mappers;

import development.v.development.application.features.PaymentMethod.CreatePaymentMethod.Dtos.CreatePaymentMethodRequestDto;
import development.v.development.domain.models.PaymentMethod;

public class CreatePaymentMethodMapper {
    public static PaymentMethod toDomain(CreatePaymentMethodRequestDto request) {
        PaymentMethod model = new PaymentMethod();
        model.setFpDescripcion(request.getFpDescripcion());
        model.setFpEstado(request.getFpEstado());
        return model;
    }
}
