package development.v.development.domain.models;

import java.time.LocalDate;

/**
 * Modelo de dominio que representa un registro individual de factura
 * para la tabla de visualización.
 */
public class InvoiceRecord {

    private Integer factId;
    private LocalDate factFecha;
    private String clienteNombre;
    private Integer factTotal;
    private String factEstado;

    public InvoiceRecord() {}

    public InvoiceRecord(Integer factId, LocalDate factFecha, String clienteNombre,
                         Integer factTotal, String factEstado) {
        this.factId = factId;
        this.factFecha = factFecha;
        this.clienteNombre = clienteNombre;
        this.factTotal = factTotal;
        this.factEstado = factEstado;
    }

    public Integer getFactId() { return factId; }
    public void setFactId(Integer factId) { this.factId = factId; }

    public LocalDate getFactFecha() { return factFecha; }
    public void setFactFecha(LocalDate factFecha) { this.factFecha = factFecha; }

    public String getClienteNombre() { return clienteNombre; }
    public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }

    public Integer getFactTotal() { return factTotal; }
    public void setFactTotal(Integer factTotal) { this.factTotal = factTotal; }

    public String getFactEstado() { return factEstado; }
    public void setFactEstado(String factEstado) { this.factEstado = factEstado; }
}

