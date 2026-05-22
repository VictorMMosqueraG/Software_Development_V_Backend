package development.v.development.application.features.Dashboard.GetDashboard;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Dashboard.GetDashboard.Dtos.InvoiceDetailResponseDto;
import development.v.development.domain.repositories.DashboardRepository;

@Service
public class GetInvoiceDetailUseCase {

    private final DashboardRepository dashboardRepository;

    public GetInvoiceDetailUseCase(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    public InvoiceDetailResponseDto execute(Integer facturaId) {
        return dashboardRepository.getInvoiceDetail(facturaId);
    }
}

