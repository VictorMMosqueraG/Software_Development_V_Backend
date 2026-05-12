package development.v.development.application.features.DiningTable.CreateDiningTable.Mappers;

import development.v.development.application.features.DiningTable.CreateDiningTable.Dtos.CreateDiningTableRequestDto;
import development.v.development.domain.models.DiningTable;

public class CreateDiningTableMapper {

    public static DiningTable toDomain(CreateDiningTableRequestDto request) {
        DiningTable domain = new DiningTable();
        domain.setSedeId(request.getSedeId());
        domain.setAreaId(request.getAreaId());
        domain.setMesaNumero(request.getMesaNumero());
        domain.setCapacidad(request.getCapacidad());
        domain.setXPos(request.getXPos());
        domain.setYPos(request.getYPos());
        domain.setEstado(request.getEstado());
        return domain;
    }
}
