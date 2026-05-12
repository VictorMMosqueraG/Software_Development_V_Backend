package development.v.development.application.features.Dish.GetAllDish.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllDishQuery extends PaginationDto {

    @Schema(description = "Filtrar por categoría", example = "1")
    private Long catId;

    @Schema(description = "Filtrar por estado", example = "1")
    private Long estId;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "plaId";

    public Long getCatId() { return catId; }
    public void setCatId(Long catId) { this.catId = catId; }
    public Long getEstId() { return estId; }
    public void setEstId(Long estId) { this.estId = estId; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
