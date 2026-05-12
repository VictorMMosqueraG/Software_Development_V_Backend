package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.StatusType;
import development.v.development.infrastruture.entities.StatusTypeEntity;
import development.v.development.infrastruture.enums.StatusTypeStatus;

public class StatusTypeMapper {
    public static StatusType toDomain(StatusTypeEntity entity) {
        StatusType domain = new StatusType();
        domain.setTesId(entity.getTesId());
        domain.setTesDescripcion(entity.getTesDescripcion());
        domain.setTesEstado(entity.getTesEstado() != null
                ? entity.getTesEstado().name() : null);
        domain.setCreatedAt(entity.getCreatedAt());
        domain.setUpdatedAt(entity.getUpdatedAt());
        return domain;
    }

    public static StatusTypeEntity toEntity(StatusType domain) {
        StatusTypeEntity entity = new StatusTypeEntity();
        entity.setTesId(domain.getTesId());
        entity.setTesDescripcion(domain.getTesDescripcion());
        if (domain.getTesEstado() != null) {
            entity.setTesEstado(StatusTypeStatus.valueOf(domain.getTesEstado()));
        }
        return entity;
    }
}
