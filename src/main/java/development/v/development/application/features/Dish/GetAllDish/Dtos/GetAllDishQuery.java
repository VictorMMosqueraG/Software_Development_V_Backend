package development.v.development.application.features.Dish.GetAllDish.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllDishQuery extends PaginationDto {

    @Schema(description = "Filtrar por estado ID", example = "1")
    private Integer estId;

    @Schema(description = "Campo por el cual ordenar", example = "plaId")
    private String sort = "plaId";

    public Integer getEstId() { return estId; }
    public void setEstId(Integer estId) { this.estId = estId; }

    @Override
    public String getSort() { return sort; }
    @Override
    public void setSort(String sort) { this.sort = sort; }
}

