package development.v.development.application.features.Branch.GetAllBranch.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllBranchQuery extends PaginationDto {

    @Schema(description = "Filtrar por estado", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String sedeEstado;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "sedeId";

    public String getSedeEstado() { return sedeEstado; }
    public void setSedeEstado(String sedeEstado) { this.sedeEstado = sedeEstado; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
