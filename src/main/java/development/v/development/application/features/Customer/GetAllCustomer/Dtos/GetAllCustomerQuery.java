package development.v.development.application.features.Customer.GetAllCustomer.Dtos;


import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllCustomerQuery  extends PaginationDto {
    @Schema(description = "Filtrar por estado", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String cliEstado;

    @Schema(description = "Filtrar por tipo de documento", example = "CC")
    private String cliTipoDocumento;

    @Schema(description = "Filtrar por número de documento", example = "1234567890")
    private String cliNumDocumento;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "cliId";    

    public String getCliEstado() { return cliEstado; }
    public void setCliEstado(String cliEstado) { this.cliEstado = cliEstado; }
    public String getCliTipoDocumento() { return cliTipoDocumento; }
    public void setCliTipoDocumento(String cliTipoDocumento) { this.cliTipoDocumento = cliTipoDocumento; }
    public String getCliNumDocumento() { return cliNumDocumento; }
    public void setCliNumDocumento(String cliNumDocumento) { this.cliNumDocumento = cliNumDocumento; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
