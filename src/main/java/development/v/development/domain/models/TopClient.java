package development.v.development.domain.models;

/**
 * Modelo de dominio que representa al cliente con mayor valor facturado.
 *
 * Se calcula filtrando solo facturas con estado "Activo", agrupando
 * por cliente y sumando fact_total, luego seleccionando el de mayor suma.
 *
 * Campos:
 *   - clienteNombre:   Nombre/Razón social del cliente
 *   - totalFacturado:  Suma total de las facturas activas del cliente
 */
public class TopClient {

    private String clienteNombre;
    private Long totalFacturado;

    public TopClient() {}

    public TopClient(String clienteNombre, Long totalFacturado) {
        this.clienteNombre = clienteNombre;
        this.totalFacturado = totalFacturado;
    }

    public String getClienteNombre() { return clienteNombre; }
    public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }

    public Long getTotalFacturado() { return totalFacturado; }
    public void setTotalFacturado(Long totalFacturado) { this.totalFacturado = totalFacturado; }
}

