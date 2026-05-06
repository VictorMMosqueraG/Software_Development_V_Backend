package development.v.development.application.features.CashReceipt.FindAllCashReceipt.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Parámetros de búsqueda y paginación para recibos de caja")
public class GetAllCashReceiptQuery extends PaginationDto {

    @Schema(description = "Filtrar por estado", example = "ACTIVO", allowableValues = {"ACTIVO", "ANULADO"})
    private String rcEstado;

    @Schema(description = "Filtrar por ID de cliente", example = "1")
    private Long cliId;

    @Schema(description = "Filtrar por ID de usuario", example = "1")
    private Long usuId;

    @Schema(description = "Filtrar por ID de sede", example = "1")
    private Long sedeId;

    private String sort = "rcNum";

    public String getRcEstado() { return rcEstado; }
    public void setRcEstado(String rcEstado) { this.rcEstado = rcEstado; }

    public Long getCliId() { return cliId; }
    public void setCliId(Long cliId) { this.cliId = cliId; }

    public Long getUsuId() { return usuId; }
    public void setUsuId(Long usuId) { this.usuId = usuId; }

    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }

    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
