package development.v.development.application.features.Reservation.GetAllReservation.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import development.v.development.infrastruture.enums.ReservationStatus;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllReservationQuery extends PaginationDto {

    @Schema(description = "Filtrar por sede", example = "1")
    private Long sedeId;

    @Schema(description = "Filtrar por estado", example = "PENDIENTE")
    private ReservationStatus resEstado;

    @Schema(description = "Filtrar por mesa", example = "1")
    private Long mesaId;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "resId";

    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public ReservationStatus getResEstado() { return resEstado; }
    public void setResEstado(ReservationStatus resEstado) { this.resEstado = resEstado; }
    public Long getMesaId() { return mesaId; }
    public void setMesaId(Long mesaId) { this.mesaId = mesaId; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
