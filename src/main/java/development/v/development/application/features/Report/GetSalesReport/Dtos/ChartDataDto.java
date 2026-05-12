package development.v.development.application.features.Report.GetSalesReport.Dtos;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Datos para las gráficas del reporte")
public class ChartDataDto {

    @Schema(description = "Gráfico de barras: cantidad por mes")
    private List<MonthlyDataDto> barrasMensual;

    @Schema(description = "Gráfico circular: consolidado general por plato")
    private List<RankingItemDto> circular;

    @Schema(description = "Gráfico de barras agrupadas: comparación por sede y mes")
    private List<BranchMonthlyDataDto> barrasAgrupadas;

    public ChartDataDto() {}

    public ChartDataDto(List<MonthlyDataDto> barrasMensual, List<RankingItemDto> circular,
                        List<BranchMonthlyDataDto> barrasAgrupadas) {
        this.barrasMensual = barrasMensual;
        this.circular = circular;
        this.barrasAgrupadas = barrasAgrupadas;
    }

    public List<MonthlyDataDto> getBarrasMensual() { return barrasMensual; }
    public void setBarrasMensual(List<MonthlyDataDto> barrasMensual) { this.barrasMensual = barrasMensual; }
    public List<RankingItemDto> getCircular() { return circular; }
    public void setCircular(List<RankingItemDto> circular) { this.circular = circular; }
    public List<BranchMonthlyDataDto> getBarrasAgrupadas() { return barrasAgrupadas; }
    public void setBarrasAgrupadas(List<BranchMonthlyDataDto> barrasAgrupadas) { this.barrasAgrupadas = barrasAgrupadas; }
}
