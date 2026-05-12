package development.v.development.application.features.Report.GetSalesReport.Dtos;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos agrupados por sede y mes para gráfico de barras agrupadas")
public class BranchMonthlyDataDto {

    @Schema(description = "ID de la sede")
    private Long sedeId;

    @Schema(description = "Nombre de la sede")
    private String sedeNombre;

    @Schema(description = "Año")
    private Integer anio;

    @Schema(description = "Mes (1-12)")
    private Integer mes;

    @Schema(description = "Nombre del mes")
    private String nombreMes;

    @Schema(description = "Cantidad total")
    private Long cantidad;

    @Schema(description = "Total facturado")
    private BigDecimal totalFacturado;

    public BranchMonthlyDataDto() {}

    public BranchMonthlyDataDto(Long sedeId, String sedeNombre, Integer anio, Integer mes,
                                 String nombreMes, Long cantidad, BigDecimal totalFacturado) {
        this.sedeId = sedeId;
        this.sedeNombre = sedeNombre;
        this.anio = anio;
        this.mes = mes;
        this.nombreMes = nombreMes;
        this.cantidad = cantidad;
        this.totalFacturado = totalFacturado;
    }

    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public String getSedeNombre() { return sedeNombre; }
    public void setSedeNombre(String sedeNombre) { this.sedeNombre = sedeNombre; }
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
