package development.v.development.application.features.Reservation.GetAllReservation.Mappers;

import development.v.development.application.features.Reservation.GetAllReservation.Dtos.GetAllReservationQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllReservationMapper {

    public static EntityFilter toFilter(GetAllReservationQuery query) {
        return new EntityFilter(query)
                .addFilter("sedeId", query.getSedeId())
                .addFilter("resEstado", query.getResEstado())
                .addFilter("mesaId", query.getMesaId());
    }
}
