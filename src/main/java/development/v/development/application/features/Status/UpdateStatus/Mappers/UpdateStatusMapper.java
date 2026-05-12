package development.v.development.application.features.Status.UpdateStatus.Mappers;

import development.v.development.application.features.Status.UpdateStatus.Dtos.UpdateStatusRequest;
import development.v.development.domain.models.Status;

public class UpdateStatusMapper {

    public static Status toDomain(Long id, UpdateStatusRequest request) {
        Status domain = new Status();
        domain.setEstId(id);
        domain.setEstDescripcion(request.getEstDescripcion());
        domain.setTesId(request.getTesId());
        domain.setEstEstado(request.getEstEstado());
        return domain;
    }
}
