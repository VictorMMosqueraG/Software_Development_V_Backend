package development.v.development.infrastruture.repositories.Invoice;

import java.time.LocalDate;

/**
 * Proyección (interface-based projection) utilizada por Spring Data JPA

 */
public interface InvoiceRecordProjection {

    Integer getFactId();

    LocalDate getFactFecha();

    String getClienteNombre();

    Integer getFactTotal();

    String getFactEstado();
}

