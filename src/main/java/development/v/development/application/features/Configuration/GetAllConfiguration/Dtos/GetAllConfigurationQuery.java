package development.v.development.application.features.Configuration.GetAllConfiguration.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllConfigurationQuery extends PaginationDto {
    @Schema(description = "Filtrar por clave", example = "NOMBRE_EMPRESA")
    private String cfgClave;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "cfgId";

    public String getCfgClave() { return cfgClave; }
    public void setCfgClave(String cfgClave) { this.cfgClave = cfgClave; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
