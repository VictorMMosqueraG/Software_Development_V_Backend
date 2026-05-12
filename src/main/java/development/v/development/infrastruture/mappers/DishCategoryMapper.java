package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.DishCategory;
import development.v.development.infrastruture.entities.DishCategoryEntity;

public class DishCategoryMapper {
    public static DishCategory toDomain(DishCategoryEntity entity) {
        DishCategory domain = new DishCategory();
        domain.setCatId(entity.getCatId());
        domain.setCatNombre(entity.getCatNombre());
        domain.setCatImagen(entity.getCatImagen());
        domain.setCatEstado(entity.getCatEstado());
        domain.setCreatedAt(entity.getCreatedAt());
        domain.setUpdatedAt(entity.getUpdatedAt());
        return domain;
    }

    public static DishCategoryEntity toEntity(DishCategory domain) {
        DishCategoryEntity entity = new DishCategoryEntity();
        entity.setCatId(domain.getCatId());
        entity.setCatNombre(domain.getCatNombre());
        entity.setCatImagen(domain.getCatImagen());
        entity.setCatEstado(domain.getCatEstado());
        return entity;
    }
}
