package development.v.development.application.features.InventoryLog.GetAllInventoryLog.Mappers;

import development.v.development.application.features.InventoryLog.GetAllInventoryLog.Dtos.GetAllInventoryLogQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllInventoryLogMapper {

    public static EntityFilter toFilter(GetAllInventoryLogQuery query) {
        return new EntityFilter(query)
                .addFilter("logTipo", query.getLogTipo())
                .addFilter("insId", query.getInsId())
                .addFilter("usuId", query.getUsuId());
    }
}
