package development.v.development.application.features.Report.GetSalesReport.Dtos;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Elemento del ranking top 5")
public class RankingItemDto {

    @Schema(description = "Identificador del registro")
    private Long id;

    @Schema(description = "Descripción del registro")
    private String descripcion;

    @Schema(description = "Cantidad total")
    private Long cantidad;

    @Schema(description = "Total facturado")
    private BigDecimal totalFacturado;

    public RankingItemDto() {}

    public RankingItemDto(Long id, String descripcion, Long cantidad, BigDecimal totalFacturado) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.totalFacturado = totalFacturado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Long getCantidad() { return cantidad; }
    public void setCantidad(Long cantidad) { this.cantidad = cantidad; }
    public BigDecimal getTotalFacturado() { return totalFacturado; }
    public void setTotalFacturado(BigDecimal totalFacturado) { this.totalFacturado = totalFacturado; }
}
