package development.v.development.application.features.Report.GetSalesReport.Dtos;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Indicadores visuales del reporte")
public class IndicatorDto {

    @Schema(description = "Total de unidades vendidas en el período")
    private Long totalUnidadesVendidas;

    @Schema(description = "Total facturado en el período")
    private BigDecimal totalFacturado;

    @Schema(description = "Promedio de venta diaria")
    private BigDecimal promedioVentaDiaria;

    @Schema(description = "Plato más vendido")
    private String platoMasVendido;

    @Schema(description = "Sede con más ventas")
    private String sedeMasVentas;

    @Schema(description = "Cantidad total de pedidos")
    private Long totalPedidos;

    public IndicatorDto() {}

    public Long getTotalUnidadesVendidas() { return totalUnidadesVendidas; }
    public void setTotalUnidadesVendidas(Long totalUnidadesVendidas) { this.totalUnidadesVendidas = totalUnidadesVendidas; }
    public BigDecimal getTotalFacturado() { return totalFacturado; }
    public void setTotalFacturado(BigDecimal totalFacturado) { this.totalFacturado = totalFacturado; }
    public BigDecimal getPromedioVentaDiaria() { return promedioVentaDiaria; }
    public void setPromedioVentaDiaria(BigDecimal promedioVentaDiaria) { this.promedioVentaDiaria = promedioVentaDiaria; }
    public String getPlatoMasVendido() { return platoMasVendido; }
    public void setPlatoMasVendido(String platoMasVendido) { this.platoMasVendido = platoMasVendido; }
    public String getSedeMasVentas() { return sedeMasVentas; }
    public void setSedeMasVentas(String sedeMasVentas) { this.sedeMasVentas = sedeMasVentas; }
    public Long getTotalPedidos() { return totalPedidos; }
    public void setTotalPedidos(Long totalPedidos) { this.totalPedidos = totalPedidos; }
}
