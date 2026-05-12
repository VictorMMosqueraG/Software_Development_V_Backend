package development.v.development.application.features.Report.GetSalesReport;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Report.GetSalesReport.Dtos.BranchMonthlyDataDto;
import development.v.development.application.features.Report.GetSalesReport.Dtos.ChartDataDto;
import development.v.development.application.features.Report.GetSalesReport.Dtos.IndicatorDto;
import development.v.development.application.features.Report.GetSalesReport.Dtos.MonthlyDataDto;
import development.v.development.application.features.Report.GetSalesReport.Dtos.RankingItemDto;
import development.v.development.application.features.Report.GetSalesReport.Dtos.ReportQuery;
import development.v.development.application.features.Report.GetSalesReport.Dtos.SalesReportResponseDto;
import development.v.development.domain.exceptions.BadRequestException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.repositories.ReportRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetSalesReportUseCase {

    private final ReportRepository reportRepository;

    public GetSalesReportUseCase(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public DataResultDto<SalesReportResponseDto> execute(ReportQuery query) {
        validateDates(query);

        List<RankingItemDto> ranking = reportRepository.getTopDishesRanking(query);
        List<MonthlyDataDto> monthlyData = reportRepository.getMonthlyData(query);
        List<BranchMonthlyDataDto> branchMonthlyData = reportRepository.getBranchMonthlyData(query);
        IndicatorDto indicators = reportRepository.getIndicators(query);

        ChartDataDto chartData = new ChartDataDto(monthlyData, ranking, branchMonthlyData);
        SalesReportResponseDto response = new SalesReportResponseDto(ranking, chartData, indicators);

        return DataResultDto.success(response, Message.SUCCESS);
    }

    private void validateDates(ReportQuery query) {
        if (query.getFechaInicio().isAfter(query.getFechaFin())) {
            throw new BadRequestException("La fecha de inicio debe ser menor a la fecha de fin");
        }
        if (query.getFechaFin().isAfter(LocalDate.now())) {
            throw new BadRequestException("La fecha de fin no puede ser mayor a la fecha actual");
        }
    }
}
