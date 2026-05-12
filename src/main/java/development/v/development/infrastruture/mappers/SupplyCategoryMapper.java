package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.SupplyCategory;
import development.v.development.infrastruture.entities.SupplyCategoryEntity;

public class SupplyCategoryMapper {
    public static SupplyCategory toDomain(SupplyCategoryEntity entity) {
        SupplyCategory supplyCategory = new SupplyCategory();
        supplyCategory.setCinsId(entity.getCinsId());
        supplyCategory.setCinsNombre(entity.getCinsNombre());
        supplyCategory.setCinsImagen(entity.getCinsImagen());
        supplyCategory.setCinsEstado(entity.getCinsEstado());
        supplyCategory.setCreatedAt(entity.getCreatedAt());
        supplyCategory.setUpdatedAt(entity.getUpdatedAt());
        return supplyCategory;
    }

    public static SupplyCategoryEntity toEntity(SupplyCategory supplyCategory) {
        SupplyCategoryEntity entity = new SupplyCategoryEntity();
        entity.setCinsId(supplyCategory.getCinsId());
        entity.setCinsNombre(supplyCategory.getCinsNombre());
        entity.setCinsImagen(supplyCategory.getCinsImagen());
        entity.setCinsEstado(supplyCategory.getCinsEstado());
        return entity;
    }
}
