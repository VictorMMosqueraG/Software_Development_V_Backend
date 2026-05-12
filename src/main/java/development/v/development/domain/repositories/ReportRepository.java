package development.v.development.domain.repositories;

import java.time.LocalDate;
import java.util.List;

import development.v.development.application.features.Report.GetReportDetail.Dtos.ReportDetailItemDto;
import development.v.development.application.features.Report.GetSalesReport.Dtos.BranchMonthlyDataDto;
import development.v.development.application.features.Report.GetSalesReport.Dtos.IndicatorDto;
import development.v.development.application.features.Report.GetSalesReport.Dtos.MonthlyDataDto;
import development.v.development.application.features.Report.GetSalesReport.Dtos.RankingItemDto;
import development.v.development.application.features.Report.GetSalesReport.Dtos.ReportQuery;

public interface ReportRepository {

    List<RankingItemDto> getTopDishesRanking(ReportQuery query);

    List<MonthlyDataDto> getMonthlyData(ReportQuery query);

    List<BranchMonthlyDataDto> getBranchMonthlyData(ReportQuery query);

    IndicatorDto getIndicators(ReportQuery query);

    List<ReportDetailItemDto> getDetailByDishIds(List<Long> plaIds, LocalDate fechaInicio,
                                                  LocalDate fechaFin, Long sedeId, Long usuId);
}
