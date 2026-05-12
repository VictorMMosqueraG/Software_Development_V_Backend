package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.PaymentMethod;
import development.v.development.infrastruture.entities.PaymentMethodEntity;
import development.v.development.infrastruture.enums.PaymentMethodStatus;

public class PaymentMethodMapper {
    public static PaymentMethod toDomain(PaymentMethodEntity entity) {
        PaymentMethod model = new PaymentMethod();
        model.setFpId(entity.getFpId());
        model.setFpDescripcion(entity.getFpDescripcion());
        model.setFpEstado(entity.getFpEstado() != null ? entity.getFpEstado().name() : null);
        model.setCreatedAt(entity.getCreatedAt());
        model.setUpdatedAt(entity.getUpdatedAt());
        return model;
    }

    public static PaymentMethodEntity toEntity(PaymentMethod model) {
        PaymentMethodEntity entity = new PaymentMethodEntity();
        entity.setFpId(model.getFpId());
        entity.setFpDescripcion(model.getFpDescripcion());
        if (model.getFpEstado() != null) {
            entity.setFpEstado(PaymentMethodStatus.valueOf(model.getFpEstado()));
        }
        return entity;
    }
}
