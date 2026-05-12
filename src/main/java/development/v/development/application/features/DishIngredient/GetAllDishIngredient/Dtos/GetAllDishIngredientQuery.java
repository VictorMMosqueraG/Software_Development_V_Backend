package development.v.development.application.features.DishIngredient.GetAllDishIngredient.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllDishIngredientQuery extends PaginationDto {

    @Schema(description = "Filtrar por plato", example = "1")
    private Long plaId;

    @Schema(description = "Filtrar por insumo", example = "1")
    private Long insId;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "piId";

    public Long getPlaId() { return plaId; }
    public void setPlaId(Long plaId) { this.plaId = plaId; }
    public Long getInsId() { return insId; }
    public void setInsId(Long insId) { this.insId = insId; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
