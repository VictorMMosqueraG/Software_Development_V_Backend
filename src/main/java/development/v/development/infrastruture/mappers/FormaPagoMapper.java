package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.FormaPago;
import development.v.development.infrastruture.entities.FormaPagoEntity;

public class FormaPagoMapper {

    public static FormaPago toDomain(FormaPagoEntity entity) {
        FormaPago model = new FormaPago();
        model.setFpId(entity.getFpId());
        model.setFpDescripcion(entity.getFpDescripcion());
        model.setFpEstado(entity.getFpEstado());
        return model;
    }
}
