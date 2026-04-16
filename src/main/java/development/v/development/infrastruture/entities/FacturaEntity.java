package development.v.development.infrastruture.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 * Entidad JPA que mapea la tabla "factura" de la base de datos bd_factura.
 *
 * Campos mapeados:
 * - fact_id:      Número de factura (PK)
 * - fact_fecha:   Fecha de la factura
 * - cli_nit:      NIT del cliente (FK a tabla cliente)
 * - fact_total:   Valor total de la factura
 * - fact_estado:  Estado de la factura (Activo, Anulada, etc.)
 */
@Entity
@Table(name = "factura")
public class FacturaEntity {

    @Id
    @Column(name = "fact_id")
    private Integer factId;

    @Column(name = "fact_fecha", nullable = false)
    private LocalDate factFecha;

    @Column(name = "cli_nit", nullable = false, length = 15)
    private String cliNit;

    @Column(name = "fact_total", nullable = false)
    private Integer factTotal;

    @Column(name = "fact_estado", nullable = false, length = 10)
    private String factEstado;

    public Integer getFactId() { return factId; }
    public void setFactId(Integer factId) { this.factId = factId; }

    public LocalDate getFactFecha() { return factFecha; }
    public void setFactFecha(LocalDate factFecha) { this.factFecha = factFecha; }

    public String getCliNit() { return cliNit; }
    public void setCliNit(String cliNit) { this.cliNit = cliNit; }

    public Integer getFactTotal() { return factTotal; }
    public void setFactTotal(Integer factTotal) { this.factTotal = factTotal; }

    public String getFactEstado() { return factEstado; }
    public void setFactEstado(String factEstado) { this.factEstado = factEstado; }
}

