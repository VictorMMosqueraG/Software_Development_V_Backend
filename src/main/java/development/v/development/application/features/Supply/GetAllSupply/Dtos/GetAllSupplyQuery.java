package development.v.development.application.features.Supply.GetAllSupply.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllSupplyQuery extends PaginationDto {

    @Schema(description = "Filtrar por estado (1=activo, 0=inactivo)", example = "1")
    private Integer insEstado;

    @Schema(description = "Filtrar por sede", example = "1")
    private Long sedeId;

    @Schema(description = "Filtrar por categoria de insumo", example = "1")
    private Long cinsId;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "insId";

    public Integer getInsEstado() { return insEstado; }
    public void setInsEstado(Integer insEstado) { this.insEstado = insEstado; }
    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public Long getCinsId() { return cinsId; }
    public void setCinsId(Long cinsId) { this.cinsId = cinsId; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
