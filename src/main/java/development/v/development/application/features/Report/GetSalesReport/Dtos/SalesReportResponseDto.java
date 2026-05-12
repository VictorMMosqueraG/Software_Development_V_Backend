package development.v.development.application.features.Report.GetSalesReport.Dtos;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Respuesta completa del reporte de ventas de platos")
public class SalesReportResponseDto {

    @Schema(description = "Ranking de los 5 platos más vendidos")
    private List<RankingItemDto> ranking;

    @Schema(description = "Datos para las gráficas")
    private ChartDataDto graficos;

    @Schema(description = "Indicadores visuales del reporte")
    private IndicatorDto indicadores;

    public SalesReportResponseDto() {}

    public SalesReportResponseDto(List<RankingItemDto> ranking, ChartDataDto graficos, IndicatorDto indicadores) {
        this.ranking = ranking;
        this.graficos = graficos;
        this.indicadores = indicadores;
    }

    public List<RankingItemDto> getRanking() { return ranking; }
    public void setRanking(List<RankingItemDto> ranking) { this.ranking = ranking; }
    public ChartDataDto getGraficos() { return graficos; }
    public void setGraficos(ChartDataDto graficos) { this.graficos = graficos; }
    public IndicatorDto getIndicadores() { return indicadores; }
    public void setIndicadores(IndicatorDto indicadores) { this.indicadores = indicadores; }
}
