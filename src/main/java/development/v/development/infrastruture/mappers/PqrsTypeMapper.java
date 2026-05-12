package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.PqrsType;
import development.v.development.infrastruture.entities.PqrsTypeEntity;
import development.v.development.infrastruture.enums.PqrsTypeStatus;

public class PqrsTypeMapper {
    public static PqrsType toDomain(PqrsTypeEntity entity) {
        PqrsType model = new PqrsType();
        model.setTpqrsId(entity.getTpqrsId());
        model.setTpqrsDescripcion(entity.getTpqrsDescripcion());
        model.setTpqrsEstado(entity.getTpqrsEstado() != null ? entity.getTpqrsEstado().name() : null);
        model.setCreatedAt(entity.getCreatedAt());
        model.setUpdatedAt(entity.getUpdatedAt());
        return model;
    }

    public static PqrsTypeEntity toEntity(PqrsType model) {
        PqrsTypeEntity entity = new PqrsTypeEntity();
        entity.setTpqrsId(model.getTpqrsId());
        entity.setTpqrsDescripcion(model.getTpqrsDescripcion());
        if (model.getTpqrsEstado() != null) {
            entity.setTpqrsEstado(PqrsTypeStatus.valueOf(model.getTpqrsEstado()));
        }
        return entity;
    }
}
