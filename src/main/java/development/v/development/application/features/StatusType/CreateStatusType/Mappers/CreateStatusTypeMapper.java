package development.v.development.application.features.StatusType.CreateStatusType.Mappers;

import development.v.development.application.features.StatusType.CreateStatusType.Dtos.CreateStatusTypeRequestDto;
import development.v.development.domain.models.StatusType;

public class CreateStatusTypeMapper {

    public static StatusType toDomain(CreateStatusTypeRequestDto request) {
        StatusType domain = new StatusType();
        domain.setTesDescripcion(request.getTesDescripcion());
        domain.setTesEstado(request.getTesEstado());
        return domain;
    }
}
