package development.v.development.application.features.Status.CreateStatus.Mappers;

import development.v.development.application.features.Status.CreateStatus.Dtos.CreateStatusRequestDto;
import development.v.development.domain.models.Status;

public class CreateStatusMapper {

    public static Status toDomain(CreateStatusRequestDto request) {
        Status domain = new Status();
        domain.setEstDescripcion(request.getEstDescripcion());
        domain.setTesId(request.getTesId());
        domain.setEstEstado(request.getEstEstado());
        return domain;
    }
}
