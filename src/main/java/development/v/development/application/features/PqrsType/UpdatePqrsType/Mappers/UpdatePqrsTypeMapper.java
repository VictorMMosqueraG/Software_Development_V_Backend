package development.v.development.application.features.PqrsType.UpdatePqrsType.Mappers;

import development.v.development.application.features.PqrsType.UpdatePqrsType.Dtos.UpdatePqrsTypeRequest;
import development.v.development.domain.models.PqrsType;

public class UpdatePqrsTypeMapper {
    public static PqrsType toDomain(Long id, UpdatePqrsTypeRequest request) {
        PqrsType model = new PqrsType();
        model.setTpqrsId(id);
        model.setTpqrsDescripcion(request.getTpqrsDescripcion());
        model.setTpqrsEstado(request.getTpqrsEstado());
        return model;
    }
}
