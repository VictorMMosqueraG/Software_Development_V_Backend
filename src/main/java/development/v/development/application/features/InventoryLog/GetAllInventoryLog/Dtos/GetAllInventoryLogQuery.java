package development.v.development.application.features.InventoryLog.GetAllInventoryLog.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllInventoryLogQuery extends PaginationDto {

    @Schema(description = "Filtrar por tipo de movimiento", example = "ENTRADA", allowableValues = {"ENTRADA", "SALIDA", "AJUSTE", "VENTA", "MERMA"})
    private String logTipo;

    @Schema(description = "Filtrar por insumo", example = "1")
    private Long insId;

    @Schema(description = "Filtrar por usuario", example = "1")
    private Long usuId;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "logId";

    public String getLogTipo() { return logTipo; }
    public void setLogTipo(String logTipo) { this.logTipo = logTipo; }
    public Long getInsId() { return insId; }
    public void setInsId(Long insId) { this.insId = insId; }
    public Long getUsuId() { return usuId; }
    public void setUsuId(Long usuId) { this.usuId = usuId; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
