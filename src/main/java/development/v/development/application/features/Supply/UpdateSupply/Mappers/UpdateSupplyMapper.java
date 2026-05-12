package development.v.development.application.features.Supply.UpdateSupply.Mappers;

import development.v.development.application.features.Supply.UpdateSupply.Dtos.UpdateSupplyRequest;
import development.v.development.domain.models.Supply;

public class UpdateSupplyMapper {

    public static Supply toDomain(Long id, UpdateSupplyRequest request) {
        Supply supply = new Supply();
        supply.setInsId(id);
        supply.setSedeId(request.getSedeId());
        supply.setCinsId(request.getCinsId());
        supply.setPresId(request.getPresId());
        supply.setInsNombre(request.getInsNombre());
        supply.setInsCodigo(request.getInsCodigo());
        supply.setInsCodigoBarras(request.getInsCodigoBarras());
        supply.setInsPrecioCompra(request.getInsPrecioCompra());
        supply.setInsStock(request.getInsStock());
        supply.setInsStockMin(request.getInsStockMin());
        supply.setInsVendible(request.getInsVendible());
        supply.setInsImagen(request.getInsImagen());
        supply.setInsEstado(request.getInsEstado());
        return supply;
    }
}
