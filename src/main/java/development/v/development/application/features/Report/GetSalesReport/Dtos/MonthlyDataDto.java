package development.v.development.application.features.Report.GetSalesReport.Dtos;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos agrupados por mes para gráfico de barras")
public class MonthlyDataDto {

    @Schema(description = "Año", example = "2025")
    private Integer anio;

    @Schema(description = "Mes (1-12)", example = "3")
    private Integer mes;

    @Schema(description = "Nombre del mes", example = "Marzo")
    private String nombreMes;

    @Schema(description = "Cantidad total en el mes")
    private Long cantidad;

    @Schema(description = "Total facturado en el mes")
    private BigDecimal totalFacturado;

    public MonthlyDataDto() {}

    public MonthlyDataDto(Integer anio, Integer mes, String nombreMes, Long cantidad, BigDecimal totalFacturado) {
        this.anio = anio;
        this.mes = mes;
        this.nombreMes = nombreMes;
        this.cantidad = cantidad;
        this.totalFacturado = totalFacturado;
    }

    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }
    public Integer getMes() { return mes; }
    public void setMes(Integer mes) { this.mes = mes; }
    public String getNombreMes() { return nombreMes; }
    public void setNombreMes(String nombreMes) { this.nombreMes = nombreMes; }
    public Long getCantidad() { return cantidad; }
    public void setCantidad(Long cantidad) { this.cantidad = cantidad; }
    public BigDecimal getTotalFacturado() { return totalFacturado; }
    public void setTotalFacturado(BigDecimal totalFacturado) { this.totalFacturado = totalFacturado; }
}
