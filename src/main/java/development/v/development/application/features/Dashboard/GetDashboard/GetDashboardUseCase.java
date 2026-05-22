package development.v.development.application.features.Dashboard.GetDashboard;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Dashboard.GetDashboard.Dtos.DashboardResponseDto;
import development.v.development.application.features.Dashboard.GetDashboard.Dtos.GetDashboardQuery;
import development.v.development.domain.repositories.DashboardRepository;

@Service
public class GetDashboardUseCase {

    private final DashboardRepository dashboardRepository;

    public GetDashboardUseCase(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    public DashboardResponseDto execute(GetDashboardQuery query) {
        return dashboardRepository.getDashboard(query);
    }
}

