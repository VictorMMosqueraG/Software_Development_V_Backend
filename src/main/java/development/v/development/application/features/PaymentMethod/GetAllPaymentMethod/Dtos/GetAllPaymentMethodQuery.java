package development.v.development.application.features.PaymentMethod.GetAllPaymentMethod.Dtos;

import development.v.development.domain.dtos.PaginationDto;
import io.swagger.v3.oas.annotations.media.Schema;

public class GetAllPaymentMethodQuery extends PaginationDto {
    @Schema(description = "Filtrar por estado", example = "ACTIVO", allowableValues = {"ACTIVO", "INACTIVO"})
    private String fpEstado;

    @Schema(description = "Campo por el cual ordenar")
    private String sort = "fpId";

    public String getFpEstado() { return fpEstado; }
    public void setFpEstado(String fpEstado) { this.fpEstado = fpEstado; }
    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }
}
