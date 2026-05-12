package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.Status;
import development.v.development.infrastruture.entities.StatusEntity;
import development.v.development.infrastruture.enums.StatusStatus;

public class StatusMapper {
    public static Status toDomain(StatusEntity entity) {
        Status domain = new Status();
        domain.setEstId(entity.getEstId());
        domain.setEstDescripcion(entity.getEstDescripcion());
        domain.setTesId(entity.getTesId());
        domain.setEstEstado(entity.getEstEstado() != null
                ? entity.getEstEstado().name() : null);
        domain.setCreatedAt(entity.getCreatedAt());
        domain.setUpdatedAt(entity.getUpdatedAt());
        return domain;
    }

    public static StatusEntity toEntity(Status domain) {
        StatusEntity entity = new StatusEntity();
        entity.setEstId(domain.getEstId());
        entity.setEstDescripcion(domain.getEstDescripcion());
        entity.setTesId(domain.getTesId());
        if (domain.getEstEstado() != null) {
            entity.setEstEstado(StatusStatus.valueOf(domain.getEstEstado()));
        }
        return entity;
    }
}
