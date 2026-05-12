package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.Supply;
import development.v.development.infrastruture.entities.SupplyEntity;

public class SupplyMapper {
    public static Supply toDomain(SupplyEntity entity) {
        Supply supply = new Supply();
        supply.setInsId(entity.getInsId());
        supply.setSedeId(entity.getSedeId());
        supply.setCinsId(entity.getCinsId());
        supply.setPresId(entity.getPresId());
        supply.setInsNombre(entity.getInsNombre());
        supply.setInsCodigo(entity.getInsCodigo());
        supply.setInsCodigoBarras(entity.getInsCodigoBarras());
        supply.setInsPrecioCompra(entity.getInsPrecioCompra());
        supply.setInsStock(entity.getInsStock());
        supply.setInsStockMin(entity.getInsStockMin());
        supply.setInsVendible(entity.getInsVendible());
        supply.setInsImagen(entity.getInsImagen());
        supply.setInsEstado(entity.getInsEstado());
        supply.setCreatedAt(entity.getCreatedAt());
        supply.setUpdatedAt(entity.getUpdatedAt());
        return supply;
    }

    public static SupplyEntity toEntity(Supply supply) {
        SupplyEntity entity = new SupplyEntity();
        entity.setInsId(supply.getInsId());
        entity.setSedeId(supply.getSedeId());
        entity.setCinsId(supply.getCinsId());
        entity.setPresId(supply.getPresId());
        entity.setInsNombre(supply.getInsNombre());
        entity.setInsCodigo(supply.getInsCodigo());
        entity.setInsCodigoBarras(supply.getInsCodigoBarras());
        entity.setInsPrecioCompra(supply.getInsPrecioCompra());
        entity.setInsStock(supply.getInsStock());
        entity.setInsStockMin(supply.getInsStockMin());
        entity.setInsVendible(supply.getInsVendible());
        entity.setInsImagen(supply.getInsImagen());
        entity.setInsEstado(supply.getInsEstado());
        return entity;
    }
}
