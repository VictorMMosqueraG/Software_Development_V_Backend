package development.v.development.application.features.Order.GetAllOrder.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Query para obtener pedidos paginados")
public class GetAllOrderQuery extends PaginationDto {

    @Schema(description = "Filtrar por ID de usuario")
    private Integer usuId;

    @Schema(description = "Filtrar por mesa")
    private String pedMesa;

    @Schema(description = "Filtrar por estado")
    private Integer estId;

    public Integer getUsuId() { return usuId; }
    public void setUsuId(Integer usuId) { this.usuId = usuId; }

    public String getPedMesa() { return pedMesa; }
    public void setPedMesa(String pedMesa) { this.pedMesa = pedMesa; }

    public Integer getEstId() { return estId; }
    public void setEstId(Integer estId) { this.estId = estId; }
}

