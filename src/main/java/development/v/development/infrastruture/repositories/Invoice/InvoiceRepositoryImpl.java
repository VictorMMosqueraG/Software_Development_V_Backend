package development.v.development.infrastruture.repositories.Invoice;

import development.v.development.domain.models.DailySales;
import development.v.development.domain.models.InvoiceDashboard;
import development.v.development.domain.models.InvoiceRecord;
import development.v.development.domain.models.TopClient;
import development.v.development.domain.repositories.InvoiceRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementación del repositorio de facturas.
 *

 */
@Repository
public class InvoiceRepositoryImpl implements InvoiceRepository {

    private final FacturaJpaRepository jpaRepository;

    public InvoiceRepositoryImpl(FacturaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public InvoiceDashboard getDashboard(String fechaInicio, String fechaFin) {


        List<InvoiceRecordProjection> rawData = jpaRepository.findInvoicesByPeriod(fechaInicio, fechaFin);


        //  Mapear TODOS los registros a la lista de la tabla

        List<InvoiceRecord> registros = rawData.stream()
                .map(p -> new InvoiceRecord(
                        p.getFactId(),
                        p.getFactFecha(),
                        p.getClienteNombre(),
                        p.getFactTotal(),
                        p.getFactEstado()))
                .collect(Collectors.toList());


        //  Filtrar SOLO facturas Activas para los cálculos
        List<InvoiceRecordProjection> activas = rawData.stream()
                .filter(p -> "Activo".equalsIgnoreCase(p.getFactEstado()))
                .collect(Collectors.toList());


        //  Calcular el cliente con MAYOR valor facturado (solo Activas)
        TopClient topClient = null;
        if (!activas.isEmpty()) {
            Map<String, Long> totalPorCliente = activas.stream()
                    .collect(Collectors.groupingBy(
                            InvoiceRecordProjection::getClienteNombre,
                            Collectors.summingLong(p -> p.getFactTotal() != null ? p.getFactTotal().longValue() : 0L)));

            // Encuentra el cliente con la mayor suma
            Map.Entry<String, Long> maxEntry = totalPorCliente.entrySet().stream()
                    .max(Comparator.comparingLong(Map.Entry::getValue))
                    .orElse(null);

            if (maxEntry != null) {
                topClient = new TopClient(maxEntry.getKey(), maxEntry.getValue());
            }
        }


        //  Calcular ventas consolidadas por DÍA (solo Activas)
        List<DailySales> ventasPorDia = new ArrayList<>();
        if (!activas.isEmpty()) {
            Map<LocalDate, Long> totalPorDia = activas.stream()
                    .collect(Collectors.groupingBy(
                            InvoiceRecordProjection::getFactFecha,
                            LinkedHashMap::new,
                            Collectors.summingLong(p -> p.getFactTotal() != null ? p.getFactTotal().longValue() : 0L)));

            ventasPorDia = totalPorDia.entrySet().stream()
                    .map(entry -> new DailySales(entry.getKey().toString(), entry.getValue()))
                    .collect(Collectors.toList());
        }

        // =====================================================================
        // PASO 6: Construir y retornar el dashboard completo
        // =====================================================================
        return new InvoiceDashboard(registros, topClient, ventasPorDia);
    }
}

