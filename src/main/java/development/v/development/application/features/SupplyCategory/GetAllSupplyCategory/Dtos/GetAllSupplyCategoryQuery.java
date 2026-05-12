package development.v.development.application.features.SupplyCategory.GetAllSupplyCategory.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllSupplyCategoryQuery extends PaginationDto {

    @Schema(description = "Filtrar por estado (1=activo, 0=inactivo)", example = "1")
    private Integer cinsEstado;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "cinsId";

    public Integer getCinsEstado() { return cinsEstado; }
    public void setCinsEstado(Integer cinsEstado) { this.cinsEstado = cinsEstado; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
