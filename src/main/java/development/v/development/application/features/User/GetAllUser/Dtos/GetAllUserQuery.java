package development.v.development.application.features.User.GetAllUser.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllUserQuery extends PaginationDto {

    @Schema(description = "Filtrar por estado", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String usuEstado;

    @Schema(description = "Filtrar por perfil ID", example = "1")
    private Long perfId;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "usuId";

    public String getUsuEstado() { return usuEstado; }
    public void setUsuEstado(String usuEstado) { this.usuEstado = usuEstado; }
    public Long getPerfId() { return perfId; }
    public void setPerfId(Long perfId) { this.perfId = perfId; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
