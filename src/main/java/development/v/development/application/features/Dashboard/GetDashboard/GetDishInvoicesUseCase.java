package development.v.development.application.features.Dashboard.GetDashboard;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Dashboard.GetDashboard.Dtos.DishInvoicesResponseDto;
import development.v.development.application.features.Dashboard.GetDashboard.Dtos.GetDishInvoicesQuery;
import development.v.development.domain.repositories.DashboardRepository;

@Service
public class GetDishInvoicesUseCase {

    private final DashboardRepository dashboardRepository;

    public GetDishInvoicesUseCase(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    public DishInvoicesResponseDto execute(GetDishInvoicesQuery query) {
        return dashboardRepository.getInvoicesByDishes(query);
    }
}

