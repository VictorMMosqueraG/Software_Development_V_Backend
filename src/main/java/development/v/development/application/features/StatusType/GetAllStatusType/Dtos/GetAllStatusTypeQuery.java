package development.v.development.application.features.StatusType.GetAllStatusType.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllStatusTypeQuery extends PaginationDto {

    @Schema(description = "Filtrar por estado", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String tesEstado;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "tesId";

    public String getTesEstado() { return tesEstado; }
    public void setTesEstado(String tesEstado) { this.tesEstado = tesEstado; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
