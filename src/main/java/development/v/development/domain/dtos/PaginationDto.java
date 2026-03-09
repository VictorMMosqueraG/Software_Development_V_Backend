package development.v.development.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Schema(description = "Parámetros de paginación")
public class PaginationDto {

    @NotNull(message = "La página es requerida")
    @Min(value = 1, message = "La página debe ser mayor a 0")
    @Schema(description = "Número de página", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer page;

    @NotNull(message = "El tamaño de página es requerido")
    @Min(value = 1, message = "El tamaño de página debe ser mayor a 0")
    @Schema(description = "Cantidad de registros por página", example = "10", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer pageSize;

    @Schema(description = "Campo por el cual ordenar", example = "rcNum")
    private String sort = "rcNum";

    @Pattern(regexp = "asc|desc", message = "El orden debe ser asc o desc")
    @Schema(description = "Dirección del ordenamiento", example = "asc", allowableValues = {"asc", "desc"})
    private String order = "asc";

    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }

    public Integer getPageSize() { return pageSize; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }

    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }

    public String getOrder() { return order; }
    public void setOrder(String order) { this.order = order; }
}