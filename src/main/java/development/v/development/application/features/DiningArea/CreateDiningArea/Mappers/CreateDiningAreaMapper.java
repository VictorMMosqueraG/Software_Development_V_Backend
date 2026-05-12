package development.v.development.application.features.DiningArea.CreateDiningArea.Mappers;

import development.v.development.application.features.DiningArea.CreateDiningArea.Dtos.CreateDiningAreaRequestDto;
import development.v.development.domain.models.DiningArea;

public class CreateDiningAreaMapper {

    public static DiningArea toDomain(CreateDiningAreaRequestDto request) {
        DiningArea domain = new DiningArea();
        domain.setSedeId(request.getSedeId());
        domain.setAreaNombre(request.getAreaNombre());
        domain.setAreaEstado(request.getAreaEstado());
        return domain;
    }
}
