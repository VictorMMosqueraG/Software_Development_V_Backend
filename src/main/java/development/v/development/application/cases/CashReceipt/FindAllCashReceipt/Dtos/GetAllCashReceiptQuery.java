package development.v.development.application.cases.CashReceipt.FindAllCashReceipt.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Parámetros de búsqueda y paginación para recibos de caja")
public class GetAllCashReceiptQuery extends PaginationDto {

    @Schema(description = "Filtrar por estado", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO", "ANULADO"})
    private String rcEstado;

    @Schema(description = "Filtrar por ID de cliente", example = "1")
    private Integer cliId;

    @Schema(description = "Filtrar por ID de usuario", example = "1")
    private Integer usuId;

    public String getRcEstado() { return rcEstado; }
    public void setRcEstado(String rcEstado) { this.rcEstado = rcEstado; }

    public Integer getCliId() { return cliId; }
    public void setCliId(Integer cliId) { this.cliId = cliId; }

    public Integer getUsuId() { return usuId; }
    public void setUsuId(Integer usuId) { this.usuId = usuId; }
}