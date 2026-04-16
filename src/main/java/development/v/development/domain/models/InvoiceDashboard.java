package development.v.development.domain.models;

import java.util.List;

/**
 * Modelo de dominio que agrupa toda la información del dashboard de facturas.
 *
 * Contiene los tres bloques de datos requeridos, todos calculados a partir
 * de UNA SOLA consulta SQL que trae las facturas del periodo con JOIN a cliente:
 *
 *  1. registros:                Lista de facturas del periodo seleccionado
 *                               (No, fecha, Cliente, valor de Venta, Estado).
 *
 *  2. clienteMayorFacturacion:  El cliente con el valor más alto facturado
 *                               considerando solo facturas con estado "Activo".
 *
 *  3. ventasPorDia:             Ventas consolidadas por día (suma de fact_total)
 *                               considerando solo facturas con estado "Activo".
 *                               Datos para graficar en el frontend.
 */
public class InvoiceDashboard {

    private List<InvoiceRecord> registros;
    private TopClient clienteMayorFacturacion;
    private List<DailySales> ventasPorDia;

    public InvoiceDashboard() {}

    public InvoiceDashboard(List<InvoiceRecord> registros,
                            TopClient clienteMayorFacturacion,
                            List<DailySales> ventasPorDia) {
        this.registros = registros;
        this.clienteMayorFacturacion = clienteMayorFacturacion;
        this.ventasPorDia = ventasPorDia;
    }

    public List<InvoiceRecord> getRegistros() { return registros; }
    public void setRegistros(List<InvoiceRecord> registros) { this.registros = registros; }

    public TopClient getClienteMayorFacturacion() { return clienteMayorFacturacion; }
    public void setClienteMayorFacturacion(TopClient clienteMayorFacturacion) {
        this.clienteMayorFacturacion = clienteMayorFacturacion;
    }

    public List<DailySales> getVentasPorDia() { return ventasPorDia; }
    public void setVentasPorDia(List<DailySales> ventasPorDia) { this.ventasPorDia = ventasPorDia; }
}

