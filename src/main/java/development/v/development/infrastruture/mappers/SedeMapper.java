package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.Sede;
import development.v.development.infrastruture.entities.SedeEntity;

public class SedeMapper {

    public static Sede toDomain(SedeEntity entity) {
        Sede model = new Sede();
        model.setSedeId(entity.getSedeId());
        model.setSedeNombre(entity.getSedeNombre());
        model.setSedeDireccion(entity.getSedeDireccion());
        model.setSedeTelefono(entity.getSedeTelefono());
        model.setSedeEstado(entity.getSedeEstado());
        return model;
    }
}
