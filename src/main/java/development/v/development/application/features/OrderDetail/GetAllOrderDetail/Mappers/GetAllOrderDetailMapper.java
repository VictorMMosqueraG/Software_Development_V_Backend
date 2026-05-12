package development.v.development.application.features.OrderDetail.GetAllOrderDetail.Mappers;

import development.v.development.application.features.OrderDetail.GetAllOrderDetail.Dtos.GetAllOrderDetailQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllOrderDetailMapper {

    public static EntityFilter toFilter(GetAllOrderDetailQuery query) {
        return new EntityFilter(query)
                .addFilter("pedId", query.getPedId())
                .addFilter("plaId", query.getPlaId())
                .addFilter("estId", query.getEstId());
    }
}
