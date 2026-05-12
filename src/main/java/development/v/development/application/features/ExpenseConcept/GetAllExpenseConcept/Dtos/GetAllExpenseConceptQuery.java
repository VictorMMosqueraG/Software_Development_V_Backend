package development.v.development.application.features.ExpenseConcept.GetAllExpenseConcept.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllExpenseConceptQuery extends PaginationDto {
    @Schema(description = "Filtrar por estado", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String conEstado;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "conId";

    public String getConEstado() { return conEstado; }
    public void setConEstado(String conEstado) { this.conEstado = conEstado; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
