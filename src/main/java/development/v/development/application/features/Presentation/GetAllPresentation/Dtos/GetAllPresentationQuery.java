package development.v.development.application.features.Presentation.GetAllPresentation.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllPresentationQuery extends PaginationDto {

    @Schema(description = "Filtrar por estado", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String presEstado;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "presId";

    public String getPresEstado() { return presEstado; }
    public void setPresEstado(String presEstado) { this.presEstado = presEstado; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
