package development.v.development.application.features.Pqrs.UpdatePqrs.Mappers;

import development.v.development.application.features.Pqrs.UpdatePqrs.Dtos.UpdatePqrsRequest;
import development.v.development.domain.models.Pqrs;

public class UpdatePqrsMapper {
    public static Pqrs toDomain(Long id, UpdatePqrsRequest request) {
        Pqrs model = new Pqrs();
        model.setPqrsId(id);
        model.setPqrsFecha(request.getPqrsFecha());
        model.setPqrsDescripcion(request.getPqrsDescripcion());
        model.setPqrsCorreo(request.getPqrsCorreo());
        model.setPqrsTelefono(request.getPqrsTelefono());
        model.setTpqrsId(request.getTpqrsId());
        model.setEstId(request.getEstId());
        model.setPqrsRespuesta(request.getPqrsRespuesta());
        model.setUsuIdResponde(request.getUsuIdResponde());
        return model;
    }
}
