package development.v.development.application.features.SupplyCategory.CreateSupplyCategory.Mappers;

import development.v.development.application.features.SupplyCategory.CreateSupplyCategory.Dtos.CreateSupplyCategoryRequestDto;
import development.v.development.domain.models.SupplyCategory;

public class CreateSupplyCategoryMapper {

    public static SupplyCategory toDomain(CreateSupplyCategoryRequestDto request) {
        SupplyCategory supplyCategory = new SupplyCategory();
        supplyCategory.setCinsNombre(request.getCinsNombre());
        supplyCategory.setCinsImagen(request.getCinsImagen());
        supplyCategory.setCinsEstado(request.getCinsEstado());
        return supplyCategory;
    }
}
