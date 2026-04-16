package development.v.development.domain.repositories;

import development.v.development.domain.models.InvoiceDashboard;

/**
 * Interfaz del repositorio de facturas en la capa de dominio.
 *
 * Define el contrato para obtener el dashboard de facturas
 * dado un rango de fechas. La implementación concreta se encuentra
 * en la capa de infraestructura (InvoiceRepositoryImpl).
 */
public interface InvoiceRepository {

    /**
     * Obtiene el dashboard completo de facturas para un periodo.
     *
     * Internamente ejecuta UNA SOLA consulta SQL que trae todos los registros
     * del periodo, y luego procesa los tres bloques de datos en Java:
     *   - Tabla de registros
     *   - Cliente con mayor facturación (solo Activas)
     *   - Ventas consolidadas por día (solo Activas)
     *
     * @param fechaInicio fecha inicio del periodo (yyyy-MM-dd)
     * @param fechaFin    fecha fin del periodo (yyyy-MM-dd)
     * @return InvoiceDashboard con los tres bloques de datos
     */
    InvoiceDashboard getDashboard(String fechaInicio, String fechaFin);
}

