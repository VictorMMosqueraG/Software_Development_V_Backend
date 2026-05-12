package development.v.development.application.features.Profile.GetAllProfile.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllProfileQuery extends PaginationDto {

    @Schema(description = "Filtrar por estado", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String perfEstado;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "perfId";

    public String getPerfEstado() { return perfEstado; }
    public void setPerfEstado(String perfEstado) { this.perfEstado = perfEstado; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
