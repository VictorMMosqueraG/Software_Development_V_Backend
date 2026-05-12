package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.DiningArea;
import development.v.development.infrastruture.entities.DiningAreaEntity;
import development.v.development.infrastruture.enums.DiningAreaStatus;

public class DiningAreaMapper {
    public static DiningArea toDomain(DiningAreaEntity entity) {
        DiningArea domain = new DiningArea();
        domain.setAreaId(entity.getAreaId());
        domain.setSedeId(entity.getSedeId());
        domain.setAreaNombre(entity.getAreaNombre());
        domain.setAreaEstado(entity.getAreaEstado() != null
                ? entity.getAreaEstado().name() : null);
        domain.setCreatedAt(entity.getCreatedAt());
        domain.setUpdatedAt(entity.getUpdatedAt());
        return domain;
    }

    public static DiningAreaEntity toEntity(DiningArea domain) {
        DiningAreaEntity entity = new DiningAreaEntity();
        entity.setAreaId(domain.getAreaId());
        entity.setSedeId(domain.getSedeId());
        entity.setAreaNombre(domain.getAreaNombre());
        if (domain.getAreaEstado() != null) {
            entity.setAreaEstado(DiningAreaStatus.valueOf(domain.getAreaEstado()));
        }
        return entity;
    }
}
