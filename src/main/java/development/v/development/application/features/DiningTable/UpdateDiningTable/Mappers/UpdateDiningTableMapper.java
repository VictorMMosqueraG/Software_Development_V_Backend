package development.v.development.application.features.DiningTable.UpdateDiningTable.Mappers;

import development.v.development.application.features.DiningTable.UpdateDiningTable.Dtos.UpdateDiningTableRequest;
import development.v.development.domain.models.DiningTable;

public class UpdateDiningTableMapper {

    public static DiningTable toDomain(Long id, UpdateDiningTableRequest request) {
        DiningTable domain = new DiningTable();
        domain.setMesaId(id);
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
