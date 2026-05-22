package development.v.development.application.features.Dashboard.GetDashboard;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Dashboard.GetDashboard.Dtos.DashboardFiltersDto;
import development.v.development.domain.repositories.DashboardRepository;

@Service
public class GetDashboardFiltersUseCase {

    private final DashboardRepository dashboardRepository;

    public GetDashboardFiltersUseCase(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    public DashboardFiltersDto execute() {
        return dashboardRepository.getDashboardFilters();
    }
}

