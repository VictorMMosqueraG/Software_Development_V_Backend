package development.v.development.application.features.DiningArea.GetAllDiningArea.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllDiningAreaQuery extends PaginationDto {

    @Schema(description = "Filtrar por estado", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String areaEstado;

    @Schema(description = "Filtrar por sede", example = "1")
    private Long sedeId;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "areaId";

    public String getAreaEstado() { return areaEstado; }
    public void setAreaEstado(String areaEstado) { this.areaEstado = areaEstado; }
    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
