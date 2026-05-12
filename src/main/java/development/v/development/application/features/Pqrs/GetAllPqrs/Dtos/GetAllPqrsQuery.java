package development.v.development.application.features.Pqrs.GetAllPqrs.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllPqrsQuery extends PaginationDto {
    @Schema(description = "Filtrar por tipo de PQRS", example = "1")
    private Long tpqrsId;

    @Schema(description = "Filtrar por estado", example = "1")
    private Long estId;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "pqrsId";

    public Long getTpqrsId() { return tpqrsId; }
    public void setTpqrsId(Long tpqrsId) { this.tpqrsId = tpqrsId; }
    public Long getEstId() { return estId; }
    public void setEstId(Long estId) { this.estId = estId; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
