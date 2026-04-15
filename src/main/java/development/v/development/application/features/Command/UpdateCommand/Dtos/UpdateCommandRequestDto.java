package development.v.development.application.features.Command.UpdateCommand.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para actualizar una comanda")
public class UpdateCommandRequestDto {

    @Schema(description = "Numero de mesa", example = "5")
    private Integer mesa;

    @Schema(description = "ID del plato", example = "1")
    private Integer plaId;

    @Schema(description = "Observaciones de la comanda", example = "Sin cebolla")
    private String comObs;

    @Schema(description = "ID del estado", example = "2")
    private Integer estId;

    public Integer getMesa() { return mesa; }
    public void setMesa(Integer mesa) { this.mesa = mesa; }

    public Integer getPlaId() { return plaId; }
    public void setPlaId(Integer plaId) { this.plaId = plaId; }

    public String getComObs() { return comObs; }
    public void setComObs(String comObs) { this.comObs = comObs; }

    public Integer getEstId() { return estId; }
    public void setEstId(Integer estId) { this.estId = estId; }
}

