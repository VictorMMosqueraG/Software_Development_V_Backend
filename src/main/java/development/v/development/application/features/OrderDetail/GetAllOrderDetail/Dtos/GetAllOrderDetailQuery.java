package development.v.development.application.features.OrderDetail.GetAllOrderDetail.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllOrderDetailQuery extends PaginationDto {

    @Schema(description = "Filtrar por pedido", example = "1")
    private Long pedId;

    @Schema(description = "Filtrar por plato", example = "1")
    private Long plaId;

    @Schema(description = "Filtrar por estado", example = "1")
    private Long estId;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "pedDetId";

    public Long getPedId() { return pedId; }
    public void setPedId(Long pedId) { this.pedId = pedId; }
    public Long getPlaId() { return plaId; }
    public void setPlaId(Long plaId) { this.plaId = plaId; }
    public Long getEstId() { return estId; }
    public void setEstId(Long estId) { this.estId = estId; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
