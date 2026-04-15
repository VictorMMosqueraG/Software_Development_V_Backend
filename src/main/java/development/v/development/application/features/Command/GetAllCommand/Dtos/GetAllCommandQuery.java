package development.v.development.application.features.Command.GetAllCommand.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Query para obtener comandas paginadas")
public class GetAllCommandQuery extends PaginationDto {

    @Schema(description = "Filtrar por mesa")
    private Integer mesa;

    @Schema(description = "Filtrar por ID de plato")
    private Integer plaId;

    @Schema(description = "Filtrar por estado")
    private Integer estId;

    public Integer getMesa() { return mesa; }
    public void setMesa(Integer mesa) { this.mesa = mesa; }

    public Integer getPlaId() { return plaId; }
    public void setPlaId(Integer plaId) { this.plaId = plaId; }

    public Integer getEstId() { return estId; }
    public void setEstId(Integer estId) { this.estId = estId; }
}

