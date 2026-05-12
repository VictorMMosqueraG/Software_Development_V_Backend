package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.Pqrs;
import development.v.development.infrastruture.entities.PqrsEntity;

public class PqrsMapper {
    public static Pqrs toDomain(PqrsEntity entity) {
        Pqrs model = new Pqrs();
        model.setPqrsId(entity.getPqrsId());
        model.setPqrsFecha(entity.getPqrsFecha());
        model.setPqrsDescripcion(entity.getPqrsDescripcion());
        model.setPqrsCorreo(entity.getPqrsCorreo());
        model.setPqrsTelefono(entity.getPqrsTelefono());
        model.setTpqrsId(entity.getTpqrsId());
        model.setEstId(entity.getEstId());
        model.setPqrsRespuesta(entity.getPqrsRespuesta());
        model.setUsuIdResponde(entity.getUsuIdResponde());
        model.setCreatedAt(entity.getCreatedAt());
        model.setUpdatedAt(entity.getUpdatedAt());
        return model;
    }

    public static PqrsEntity toEntity(Pqrs model) {
        PqrsEntity entity = new PqrsEntity();
        entity.setPqrsId(model.getPqrsId());
        entity.setPqrsFecha(model.getPqrsFecha());
        entity.setPqrsDescripcion(model.getPqrsDescripcion());
        entity.setPqrsCorreo(model.getPqrsCorreo());
        entity.setPqrsTelefono(model.getPqrsTelefono());
        entity.setTpqrsId(model.getTpqrsId());
        entity.setEstId(model.getEstId());
        entity.setPqrsRespuesta(model.getPqrsRespuesta());
        entity.setUsuIdResponde(model.getUsuIdResponde());
        return entity;
    }
}
