package development.v.development.application.features.PqrsType.GetAllPqrsType.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllPqrsTypeQuery extends PaginationDto {
    @Schema(description = "Filtrar por estado", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String tpqrsEstado;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "tpqrsId";

    public String getTpqrsEstado() { return tpqrsEstado; }
    public void setTpqrsEstado(String tpqrsEstado) { this.tpqrsEstado = tpqrsEstado; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
