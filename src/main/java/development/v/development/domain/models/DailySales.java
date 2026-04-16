package development.v.development.domain.models;

/**
 * Modelo de dominio que representa las ventas consolidadas de un día.
 */
public class DailySales {

    private String fecha;
    private Long totalVenta;

    public DailySales() {}

    public DailySales(String fecha, Long totalVenta) {
        this.fecha = fecha;
        this.totalVenta = totalVenta;
    }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public Long getTotalVenta() { return totalVenta; }
    public void setTotalVenta(Long totalVenta) { this.totalVenta = totalVenta; }
}

