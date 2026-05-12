package development.v.development.application.features.StatusType.UpdateStatusType.Mappers;

import development.v.development.application.features.StatusType.UpdateStatusType.Dtos.UpdateStatusTypeRequest;
import development.v.development.domain.models.StatusType;

public class UpdateStatusTypeMapper {

    public static StatusType toDomain(Long id, UpdateStatusTypeRequest request) {
        StatusType domain = new StatusType();
        domain.setTesId(id);
        domain.setTesDescripcion(request.getTesDescripcion());
        domain.setTesEstado(request.getTesEstado());
        return domain;
    }
}
