package development.v.development.application.features.Pqrs.CreatePqrs.Mappers;

import development.v.development.application.features.Pqrs.CreatePqrs.Dtos.CreatePqrsRequestDto;
import development.v.development.domain.models.Pqrs;

public class CreatePqrsMapper {
    public static Pqrs toDomain(CreatePqrsRequestDto request) {
        Pqrs model = new Pqrs();
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
