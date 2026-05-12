package development.v.development.application.features.DishCategory.GetAllDishCategory.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllDishCategoryQuery extends PaginationDto {

    @Schema(description = "Filtrar por estado (1=Activo, 0=Inactivo)", example = "1", allowableValues = {"0", "1"})
    private Integer catEstado;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "catId";

    public Integer getCatEstado() { return catEstado; }
    public void setCatEstado(Integer catEstado) { this.catEstado = catEstado; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
