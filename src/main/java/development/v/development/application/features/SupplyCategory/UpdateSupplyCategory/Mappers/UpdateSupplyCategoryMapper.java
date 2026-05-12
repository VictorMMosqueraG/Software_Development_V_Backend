package development.v.development.application.features.SupplyCategory.UpdateSupplyCategory.Mappers;

import development.v.development.application.features.SupplyCategory.UpdateSupplyCategory.Dtos.UpdateSupplyCategoryRequest;
import development.v.development.domain.models.SupplyCategory;

public class UpdateSupplyCategoryMapper {

    public static SupplyCategory toDomain(Long id, UpdateSupplyCategoryRequest request) {
        SupplyCategory supplyCategory = new SupplyCategory();
        supplyCategory.setCinsId(id);
        supplyCategory.setCinsNombre(request.getCinsNombre());
        supplyCategory.setCinsImagen(request.getCinsImagen());
        supplyCategory.setCinsEstado(request.getCinsEstado());
        return supplyCategory;
    }
}
