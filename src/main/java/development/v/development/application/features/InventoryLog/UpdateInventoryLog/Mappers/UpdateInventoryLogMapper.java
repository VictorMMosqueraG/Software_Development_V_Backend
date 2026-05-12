package development.v.development.application.features.InventoryLog.UpdateInventoryLog.Mappers;

import development.v.development.application.features.InventoryLog.UpdateInventoryLog.Dtos.UpdateInventoryLogRequest;
import development.v.development.domain.models.InventoryLog;

public class UpdateInventoryLogMapper {

    public static InventoryLog toDomain(Long id, UpdateInventoryLogRequest request) {
        InventoryLog inventoryLog = new InventoryLog();
        inventoryLog.setLogId(id);
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
