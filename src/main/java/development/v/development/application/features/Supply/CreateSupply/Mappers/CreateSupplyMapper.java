package development.v.development.application.features.Supply.CreateSupply.Mappers;

import development.v.development.application.features.Supply.CreateSupply.Dtos.CreateSupplyRequestDto;
import development.v.development.domain.models.Supply;

public class CreateSupplyMapper {

    public static Supply toDomain(CreateSupplyRequestDto request) {
        Supply supply = new Supply();
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
