package development.v.development.application.features.DiningArea.UpdateDiningArea.Mappers;

import development.v.development.application.features.DiningArea.UpdateDiningArea.Dtos.UpdateDiningAreaRequest;
import development.v.development.domain.models.DiningArea;

public class UpdateDiningAreaMapper {

    public static DiningArea toDomain(Long id, UpdateDiningAreaRequest request) {
        DiningArea domain = new DiningArea();
        domain.setAreaId(id);
        domain.setSedeId(request.getSedeId());
        domain.setAreaNombre(request.getAreaNombre());
        domain.setAreaEstado(request.getAreaEstado());
        return domain;
    }
}
