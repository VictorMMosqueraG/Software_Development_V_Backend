package development.v.development.application.features.Report.GetReportDetail;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Report.GetReportDetail.Dtos.ReportDetailItemDto;
import development.v.development.application.features.Report.GetReportDetail.Dtos.ReportDetailQuery;
import development.v.development.domain.messages.Message;
import development.v.development.domain.repositories.ReportRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetReportDetailUseCase {

    private final ReportRepository reportRepository;

    public GetReportDetailUseCase(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public DataResultDto<List<ReportDetailItemDto>> execute(ReportDetailQuery query) {
        List<ReportDetailItemDto> details = reportRepository.getDetailByDishIds(
                query.getPlaIds(),
                query.getFechaInicio(),
                query.getFechaFin(),
                query.getSedeId(),
                query.getUsuId()
        );
        return DataResultDto.success(details, Message.SUCCESS);
    }
}
