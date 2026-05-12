package development.v.development.application.features.ExpenseHeader.GetAllExpenseHeader.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllExpenseHeaderQuery extends PaginationDto {
    @Schema(description = "Filtrar por estado", example = "ACTIVO", allowableValues = {"ACTIVO", "ANULADO"})
    private String egrEstado;

    @Schema(description = "Filtrar por sede", example = "1")
    private Long sedeId;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "egrId";

    public String getEgrEstado() { return egrEstado; }
    public void setEgrEstado(String egrEstado) { this.egrEstado = egrEstado; }
    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
