package development.v.development.domain.repositories;

import development.v.development.application.features.Dashboard.GetDashboard.Dtos.DashboardFiltersDto;
import development.v.development.application.features.Dashboard.GetDashboard.Dtos.DishInvoicesResponseDto;
import development.v.development.application.features.Dashboard.GetDashboard.Dtos.DashboardResponseDto;
import development.v.development.application.features.Dashboard.GetDashboard.Dtos.GetDishInvoicesQuery;
import development.v.development.application.features.Dashboard.GetDashboard.Dtos.GetDashboardQuery;
import development.v.development.application.features.Dashboard.GetDashboard.Dtos.InvoiceDetailResponseDto;

public interface DashboardRepository {
    DashboardResponseDto getDashboard(GetDashboardQuery query);
    DashboardFiltersDto getDashboardFilters();
    DishInvoicesResponseDto getInvoicesByDishes(GetDishInvoicesQuery query);
    InvoiceDetailResponseDto getInvoiceDetail(Integer facturaId);
}

