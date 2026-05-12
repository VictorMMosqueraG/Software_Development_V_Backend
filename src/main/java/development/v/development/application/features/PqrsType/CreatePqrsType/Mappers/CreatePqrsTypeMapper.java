package development.v.development.application.features.PqrsType.CreatePqrsType.Mappers;

import development.v.development.application.features.PqrsType.CreatePqrsType.Dtos.CreatePqrsTypeRequestDto;
import development.v.development.domain.models.PqrsType;

public class CreatePqrsTypeMapper {
    public static PqrsType toDomain(CreatePqrsTypeRequestDto request) {
        PqrsType model = new PqrsType();
        model.setTpqrsDescripcion(request.getTpqrsDescripcion());
        model.setTpqrsEstado(request.getTpqrsEstado());
        return model;
    }
}
