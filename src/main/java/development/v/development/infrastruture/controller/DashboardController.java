package development.v.development.infrastruture.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import development.v.development.application.features.Dashboard.GetDashboard.GetDishInvoicesUseCase;
import development.v.development.application.features.Dashboard.GetDashboard.GetDashboardFiltersUseCase;
import development.v.development.application.features.Dashboard.GetDashboard.GetDashboardUseCase;
import development.v.development.application.features.Dashboard.GetDashboard.Dtos.DashboardFiltersDto;
import development.v.development.application.features.Dashboard.GetDashboard.Dtos.DishInvoicesResponseDto;
import development.v.development.application.features.Dashboard.GetDashboard.Dtos.DashboardResponseDto;
import development.v.development.application.features.Dashboard.GetDashboard.Dtos.GetDishInvoicesQuery;
import development.v.development.application.features.Dashboard.GetDashboard.Dtos.GetDashboardQuery;
import development.v.development.application.features.Dashboard.GetDashboard.Dtos.InvoiceDetailResponseDto;
import development.v.development.application.features.Dashboard.GetDashboard.GetInvoiceDetailUseCase;
import development.v.development.domain.messages.Message;
import development.v.development.domain.responses.DataResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/dashboard")
@Tag(name = "Dashboard", description = "Consultas consolidadas para tablero")
public class DashboardController {

    private final GetDashboardUseCase getDashboardUseCase;
    private final GetDashboardFiltersUseCase getDashboardFiltersUseCase;
    private final GetDishInvoicesUseCase getDishInvoicesUseCase;
    private final GetInvoiceDetailUseCase getInvoiceDetailUseCase;

    public DashboardController(
            GetDashboardUseCase getDashboardUseCase,
            GetDashboardFiltersUseCase getDashboardFiltersUseCase,
            GetDishInvoicesUseCase getDishInvoicesUseCase,
            GetInvoiceDetailUseCase getInvoiceDetailUseCase) {
        this.getDashboardUseCase = getDashboardUseCase;
        this.getDashboardFiltersUseCase = getDashboardFiltersUseCase;
        this.getDishInvoicesUseCase = getDishInvoicesUseCase;
        this.getInvoiceDetailUseCase = getInvoiceDetailUseCase;
    }

    @Operation(summary = "Obtiene metricas del dashboard", description = "Retorna top platos, consolidado por sede/mes y atencion por mesero")
    @GetMapping
    public ResponseEntity<DataResultDto<DashboardResponseDto>> getDashboard(
            @ParameterObject @Valid @ModelAttribute GetDashboardQuery query) {
        DashboardResponseDto data = getDashboardUseCase.execute(query);
        return ResponseEntity.ok(DataResultDto.success(data, Message.SUCCESS));
    }

    @Operation(summary = "Obtiene catalogos de filtros", description = "Retorna las opciones de mesero, plato, estado y sede")
    @GetMapping("/filters")
    public ResponseEntity<DataResultDto<DashboardFiltersDto>> getFilters() {
        DashboardFiltersDto data = getDashboardFiltersUseCase.execute();
        return ResponseEntity.ok(DataResultDto.success(data, Message.SUCCESS));
    }

    @Operation(summary = "Busca facturas por platos", description = "Retorna las facturas que contienen todos o algunos platos seleccionados")
    @GetMapping("/facturas")
    public ResponseEntity<DataResultDto<DishInvoicesResponseDto>> getInvoicesByDishes(
            @ParameterObject @Valid @ModelAttribute GetDishInvoicesQuery query) {
        DishInvoicesResponseDto data = getDishInvoicesUseCase.execute(query);
        return ResponseEntity.ok(DataResultDto.success(data, Message.SUCCESS));
    }

    @Operation(summary = "Obtiene detalle de factura", description = "Retorna el detalle completo de una factura para navegar desde el dashboard")
    @GetMapping("/facturas/{facturaId}")
    public ResponseEntity<DataResultDto<InvoiceDetailResponseDto>> getInvoiceDetail(
            @PathVariable Integer facturaId) {
        InvoiceDetailResponseDto data = getInvoiceDetailUseCase.execute(facturaId);
        return ResponseEntity.ok(DataResultDto.success(data, Message.SUCCESS));
    }
}

