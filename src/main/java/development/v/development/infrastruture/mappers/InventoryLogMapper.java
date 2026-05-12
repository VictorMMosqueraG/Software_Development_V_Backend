package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.InventoryLog;
import development.v.development.infrastruture.entities.InventoryLogEntity;
import development.v.development.infrastruture.enums.InventoryLogType;

public class InventoryLogMapper {
    public static InventoryLog toDomain(InventoryLogEntity entity) {
        InventoryLog inventoryLog = new InventoryLog();
        inventoryLog.setLogId(entity.getLogId());
        inventoryLog.setInsId(entity.getInsId());
        inventoryLog.setUsuId(entity.getUsuId());
        inventoryLog.setLogTipo(entity.getLogTipo() != null
                ? entity.getLogTipo().name() : null);
        inventoryLog.setLogCantidad(entity.getLogCantidad());
        inventoryLog.setLogStockAnt(entity.getLogStockAnt());
        inventoryLog.setLogStockNvo(entity.getLogStockNvo());
        inventoryLog.setLogNota(entity.getLogNota());
        inventoryLog.setCreatedAt(entity.getCreatedAt());
        inventoryLog.setUpdatedAt(entity.getUpdatedAt());
        return inventoryLog;
    }

    public static InventoryLogEntity toEntity(InventoryLog inventoryLog) {
        InventoryLogEntity entity = new InventoryLogEntity();
        entity.setLogId(inventoryLog.getLogId());
        entity.setInsId(inventoryLog.getInsId());
        entity.setUsuId(inventoryLog.getUsuId());
        if (inventoryLog.getLogTipo() != null) {
            entity.setLogTipo(InventoryLogType
                    .valueOf(inventoryLog.getLogTipo()));
        }
        entity.setLogCantidad(inventoryLog.getLogCantidad());
        entity.setLogStockAnt(inventoryLog.getLogStockAnt());
        entity.setLogStockNvo(inventoryLog.getLogStockNvo());
        entity.setLogNota(inventoryLog.getLogNota());
        return entity;
    }
}
