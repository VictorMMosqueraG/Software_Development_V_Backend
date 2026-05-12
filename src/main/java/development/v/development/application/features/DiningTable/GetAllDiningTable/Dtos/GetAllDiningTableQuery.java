package development.v.development.application.features.DiningTable.GetAllDiningTable.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllDiningTableQuery extends PaginationDto {

    @Schema(description = "Filtrar por estado", example = "DISPONIBLE", allowableValues = {"DISPONIBLE", "OCUPADA", "RESERVADA", "INACTIVA"})
    private String estado;

    @Schema(description = "Filtrar por sede", example = "1")
    private Long sedeId;

    @Schema(description = "Filtrar por area", example = "1")
    private Long areaId;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "mesaId";

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public Long getAreaId() { return areaId; }
    public void setAreaId(Long areaId) { this.areaId = areaId; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
