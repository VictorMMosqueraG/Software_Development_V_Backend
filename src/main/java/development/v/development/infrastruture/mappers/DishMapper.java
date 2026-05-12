package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.Dish;
import development.v.development.infrastruture.entities.DishEntity;

public class DishMapper {

    public static Dish toDomain(DishEntity entity) {
        Dish model = new Dish();
        model.setPlaId(entity.getPlaId());
        model.setCatId(entity.getCatId());
        model.setPlaDescripcion(entity.getPlaDescripcion());
        model.setPlaCodigo(entity.getPlaCodigo());
        model.setPlaPrecio(entity.getPlaPrecio());
        model.setPlaCosto(entity.getPlaCosto());
        model.setPlaImagen(entity.getPlaImagen());
        model.setEstId(entity.getEstId());
        model.setCreatedAt(entity.getCreatedAt());
        model.setUpdatedAt(entity.getUpdatedAt());
        return model;
    }

    public static DishEntity toEntity(Dish model) {
        DishEntity entity = new DishEntity();
        entity.setPlaId(model.getPlaId());
        entity.setCatId(model.getCatId());
        entity.setPlaDescripcion(model.getPlaDescripcion());
        entity.setPlaCodigo(model.getPlaCodigo());
        entity.setPlaPrecio(model.getPlaPrecio());
        entity.setPlaCosto(model.getPlaCosto());
        entity.setPlaImagen(model.getPlaImagen());
        entity.setEstId(model.getEstId());
        return entity;
    }
}
