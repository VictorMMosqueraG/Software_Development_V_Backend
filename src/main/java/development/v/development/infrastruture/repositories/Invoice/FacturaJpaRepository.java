package development.v.development.infrastruture.repositories.Invoice;

import development.v.development.infrastruture.entities.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio JPA para la entidad Factura.

 */
@Repository
public interface FacturaJpaRepository extends JpaRepository<FacturaEntity, Integer> {

    /**
     * Consulta nativa que une factura + cliente y filtra por rango de fechas.
     *

     */
    @Query(value = "SELECT f.fact_id       AS factId, " +
                   "       f.fact_fecha    AS factFecha, " +
                   "       c.cli_razon_social AS clienteNombre, " +
                   "       f.fact_total    AS factTotal, " +
                   "       f.fact_estado   AS factEstado " +
                   "FROM   factura f " +
                   "INNER JOIN cliente c ON f.cli_nit = c.cli_nit " +
                   "WHERE  f.fact_fecha BETWEEN :fechaInicio AND :fechaFin " +
                   "ORDER BY f.fact_fecha, f.fact_id",
           nativeQuery = true)
    List<InvoiceRecordProjection> findInvoicesByPeriod(
            @Param("fechaInicio") String fechaInicio,
            @Param("fechaFin") String fechaFin);
}

