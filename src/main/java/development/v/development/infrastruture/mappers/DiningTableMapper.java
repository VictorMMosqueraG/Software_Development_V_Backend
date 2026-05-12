package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.DiningTable;
import development.v.development.infrastruture.entities.DiningTableEntity;
import development.v.development.infrastruture.enums.DiningTableStatus;

public class DiningTableMapper {
    public static DiningTable toDomain(DiningTableEntity entity) {
        DiningTable domain = new DiningTable();
        domain.setMesaId(entity.getMesaId());
        domain.setSedeId(entity.getSedeId());
        domain.setAreaId(entity.getAreaId());
        domain.setMesaNumero(entity.getMesaNumero());
        domain.setCapacidad(entity.getCapacidad());
        domain.setXPos(entity.getXPos());
        domain.setYPos(entity.getYPos());
        domain.setEstado(entity.getEstado() != null
                ? entity.getEstado().name() : null);
        domain.setCreatedAt(entity.getCreatedAt());
        domain.setUpdatedAt(entity.getUpdatedAt());
        return domain;
    }

    public static DiningTableEntity toEntity(DiningTable domain) {
        DiningTableEntity entity = new DiningTableEntity();
        entity.setMesaId(domain.getMesaId());
        entity.setSedeId(domain.getSedeId());
        entity.setAreaId(domain.getAreaId());
        entity.setMesaNumero(domain.getMesaNumero());
        entity.setCapacidad(domain.getCapacidad());
        entity.setXPos(domain.getXPos());
        entity.setYPos(domain.getYPos());
        if (domain.getEstado() != null) {
            entity.setEstado(DiningTableStatus.valueOf(domain.getEstado()));
        }
        return entity;
    }
}
