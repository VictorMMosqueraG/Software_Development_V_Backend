package development.v.development.application.cases.Invoice.GetInvoiceDashboard;

import development.v.development.domain.messages.Message;
import development.v.development.domain.models.InvoiceDashboard;
import development.v.development.domain.repositories.InvoiceRepository;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.application.cases.Invoice.GetInvoiceDashboard.Dtos.InvoiceDashboardQuery;
import org.springframework.stereotype.Service;

/**
 * Caso de uso: Obtener Dashboard de Facturas.
 */

@Service
public class GetInvoiceDashboardUseCase {

    private final InvoiceRepository repository;

    public GetInvoiceDashboardUseCase(InvoiceRepository repository) {
        this.repository = repository;
    }

    /**
     * Ejecuta el caso de uso.
     *
     * @param query contiene fechaInicio y fechaFin del periodo
     * @return DataResultDto con el InvoiceDashboard completo
     */
    public DataResultDto<InvoiceDashboard> execute(InvoiceDashboardQuery query) {
        InvoiceDashboard dashboard = repository.getDashboard(
                query.getFechaInicio(),
                query.getFechaFin());

        return DataResultDto.success(dashboard, Message.SUCCESS);
    }
}

