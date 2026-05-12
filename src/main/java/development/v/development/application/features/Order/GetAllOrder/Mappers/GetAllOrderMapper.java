package development.v.development.application.features.Order.GetAllOrder.Mappers;

import development.v.development.application.features.Order.GetAllOrder.Dtos.GetAllOrderQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllOrderMapper {

    public static EntityFilter toFilter(GetAllOrderQuery query) {
        return new EntityFilter(query)
                .addFilter("sedeId", query.getSedeId())
                .addFilter("estId", query.getEstId())
                .addFilter("usuId", query.getUsuId());
    }
}
