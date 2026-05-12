package development.v.development.application.features.Order.GetAllOrder.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllOrderQuery extends PaginationDto {

    @Schema(description = "Filtrar por sede", example = "1")
    private Long sedeId;

    @Schema(description = "Filtrar por estado", example = "1")
    private Long estId;

    @Schema(description = "Filtrar por usuario", example = "1")
    private Long usuId;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "pedId";

    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public Long getEstId() { return estId; }
    public void setEstId(Long estId) { this.estId = estId; }
    public Long getUsuId() { return usuId; }
    public void setUsuId(Long usuId) { this.usuId = usuId; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
