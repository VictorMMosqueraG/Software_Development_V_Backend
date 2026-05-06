package development.v.development.application.features.CashReceiptDetail.FindAllCashReceiptDetail.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Parámetros de búsqueda y paginación para detalles de recibo de caja")
public class GetAllCashReceiptDetailQuery extends PaginationDto {

    @Schema(description = "Filtrar por número de recibo", example = "1")
    private Long rcNum;

    @Schema(description = "Filtrar por ID de plato", example = "1")
    private Long plaId;

    private String sort = "rcdId";

    public Long getRcNum() { return rcNum; }
    public void setRcNum(Long rcNum) { this.rcNum = rcNum; }

    public Long getPlaId() { return plaId; }
    public void setPlaId(Long plaId) { this.plaId = plaId; }

    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
