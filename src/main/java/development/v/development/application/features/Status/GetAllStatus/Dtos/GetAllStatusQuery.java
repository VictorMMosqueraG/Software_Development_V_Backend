package development.v.development.application.features.Status.GetAllStatus.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllStatusQuery extends PaginationDto {

    @Schema(description = "Filtrar por estado", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String estEstado;

    @Schema(description = "Filtrar por tipo de estado", example = "1")
    private Long tesId;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "estId";

    public String getEstEstado() { return estEstado; }
    public void setEstEstado(String estEstado) { this.estEstado = estEstado; }
    public Long getTesId() { return tesId; }
    public void setTesId(Long tesId) { this.tesId = tesId; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
