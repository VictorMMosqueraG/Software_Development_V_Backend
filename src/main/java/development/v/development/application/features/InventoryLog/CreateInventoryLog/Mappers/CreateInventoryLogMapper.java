package development.v.development.application.features.InventoryLog.CreateInventoryLog.Mappers;

import development.v.development.application.features.InventoryLog.CreateInventoryLog.Dtos.CreateInventoryLogRequestDto;
import development.v.development.domain.models.InventoryLog;

public class CreateInventoryLogMapper {

    public static InventoryLog toDomain(CreateInventoryLogRequestDto request) {
        InventoryLog inventoryLog = new InventoryLog();
        inventoryLog.setInsId(request.getInsId());
        inventoryLog.setUsuId(request.getUsuId());
        inventoryLog.setLogTipo(request.getLogTipo());
        inventoryLog.setLogCantidad(request.getLogCantidad());
        inventoryLog.setLogStockAnt(request.getLogStockAnt());
        inventoryLog.setLogStockNvo(request.getLogStockNvo());
        inventoryLog.setLogNota(request.getLogNota());
        return inventoryLog;
    }
}
