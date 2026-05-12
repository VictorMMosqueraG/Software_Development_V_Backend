package development.v.development.infrastruture.repositories.Report;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import development.v.development.application.features.Report.GetReportDetail.Dtos.ReportDetailItemDto;
import development.v.development.application.features.Report.GetSalesReport.Dtos.BranchMonthlyDataDto;
import development.v.development.application.features.Report.GetSalesReport.Dtos.IndicatorDto;
import development.v.development.application.features.Report.GetSalesReport.Dtos.MonthlyDataDto;
import development.v.development.application.features.Report.GetSalesReport.Dtos.RankingItemDto;
import development.v.development.application.features.Report.GetSalesReport.Dtos.ReportQuery;
import development.v.development.domain.repositories.ReportRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class ReportRepositoryImpl implements ReportRepository {

    private final EntityManager entityManager;

    private static final String[] MONTH_NAMES = {
        "", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };

    public ReportRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<RankingItemDto> getTopDishesRanking(ReportQuery query) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT p.pla_id, p.pla_descripcion, ");
        sql.append("SUM(pd.ped_det_cant) AS cantidad, ");
        sql.append("SUM(pd.ped_det_cant * pd.ped_det_precio) AS total_facturado ");
        sql.append("FROM pedido_detalle pd ");
        sql.append("INNER JOIN pedido pe ON pe.ped_id = pd.ped_id ");
        sql.append("INNER JOIN plato p ON p.pla_id = pd.pla_id ");
        sql.append("WHERE pe.ped_fecha BETWEEN :fechaInicio AND :fechaFin ");

        appendOptionalFilters(sql, query);

        sql.append("GROUP BY p.pla_id, p.pla_descripcion ");
        sql.append("ORDER BY cantidad DESC ");
        sql.append("LIMIT 5");

        Query nativeQuery = entityManager.createNativeQuery(sql.toString());
        setCommonParameters(nativeQuery, query);

        @SuppressWarnings("unchecked")
        List<Object[]> results = nativeQuery.getResultList();

        List<RankingItemDto> ranking = new ArrayList<>();
        for (Object[] row : results) {
            ranking.add(new RankingItemDto(
                    toLong(row[0]),
                    (String) row[1],
                    toLong(row[2]),
                    toBigDecimal(row[3])
            ));
        }
        return ranking;
    }

    @Override
    public List<MonthlyDataDto> getMonthlyData(ReportQuery query) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT YEAR(pe.ped_fecha) AS anio, MONTH(pe.ped_fecha) AS mes, ");
        sql.append("SUM(pd.ped_det_cant) AS cantidad, ");
        sql.append("SUM(pd.ped_det_cant * pd.ped_det_precio) AS total_facturado ");
        sql.append("FROM pedido_detalle pd ");
        sql.append("INNER JOIN pedido pe ON pe.ped_id = pd.ped_id ");
        sql.append("WHERE pe.ped_fecha BETWEEN :fechaInicio AND :fechaFin ");

        appendOptionalFilters(sql, query);

        sql.append("GROUP BY YEAR(pe.ped_fecha), MONTH(pe.ped_fecha) ");
        sql.append("ORDER BY anio, mes");

        Query nativeQuery = entityManager.createNativeQuery(sql.toString());
        setCommonParameters(nativeQuery, query);

        @SuppressWarnings("unchecked")
        List<Object[]> results = nativeQuery.getResultList();

        List<MonthlyDataDto> data = new ArrayList<>();
        for (Object[] row : results) {
            Integer anio = toInteger(row[0]);
            Integer mes = toInteger(row[1]);
            data.add(new MonthlyDataDto(
                    anio, mes, MONTH_NAMES[mes],
                    toLong(row[2]),
                    toBigDecimal(row[3])
            ));
        }
        return data;
    }

    @Override
    public List<BranchMonthlyDataDto> getBranchMonthlyData(ReportQuery query) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT s.sede_id, s.sede_nombre, ");
        sql.append("YEAR(pe.ped_fecha) AS anio, MONTH(pe.ped_fecha) AS mes, ");
        sql.append("SUM(pd.ped_det_cant) AS cantidad, ");
        sql.append("SUM(pd.ped_det_cant * pd.ped_det_precio) AS total_facturado ");
        sql.append("FROM pedido_detalle pd ");
        sql.append("INNER JOIN pedido pe ON pe.ped_id = pd.ped_id ");
        sql.append("INNER JOIN sede s ON s.sede_id = pe.sede_id ");
        sql.append("WHERE pe.ped_fecha BETWEEN :fechaInicio AND :fechaFin ");

        appendOptionalFilters(sql, query);

        sql.append("GROUP BY s.sede_id, s.sede_nombre, YEAR(pe.ped_fecha), MONTH(pe.ped_fecha) ");
        sql.append("ORDER BY s.sede_nombre, anio, mes");

        Query nativeQuery = entityManager.createNativeQuery(sql.toString());
        setCommonParameters(nativeQuery, query);

        @SuppressWarnings("unchecked")
        List<Object[]> results = nativeQuery.getResultList();

        List<BranchMonthlyDataDto> data = new ArrayList<>();
        for (Object[] row : results) {
            Integer anio = toInteger(row[2]);
            Integer mes = toInteger(row[3]);
            data.add(new BranchMonthlyDataDto(
                    toLong(row[0]),
                    (String) row[1],
                    anio, mes, MONTH_NAMES[mes],
                    toLong(row[4]),
                    toBigDecimal(row[5])
            ));
        }
        return data;
    }

    @Override
    public IndicatorDto getIndicators(ReportQuery query) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ");
        sql.append("SUM(pd.ped_det_cant) AS total_unidades, ");
        sql.append("SUM(pd.ped_det_cant * pd.ped_det_precio) AS total_facturado, ");
        sql.append("COUNT(DISTINCT pe.ped_id) AS total_pedidos ");
        sql.append("FROM pedido_detalle pd ");
        sql.append("INNER JOIN pedido pe ON pe.ped_id = pd.ped_id ");
        sql.append("WHERE pe.ped_fecha BETWEEN :fechaInicio AND :fechaFin ");

        appendOptionalFilters(sql, query);

        Query nativeQuery = entityManager.createNativeQuery(sql.toString());
        setCommonParameters(nativeQuery, query);

        Object[] row = (Object[]) nativeQuery.getSingleResult();

        IndicatorDto indicator = new IndicatorDto();
        indicator.setTotalUnidadesVendidas(row[0] != null ? toLong(row[0]) : 0L);
        indicator.setTotalFacturado(row[1] != null ? toBigDecimal(row[1]) : BigDecimal.ZERO);
        indicator.setTotalPedidos(row[2] != null ? toLong(row[2]) : 0L);

        long days = ChronoUnit.DAYS.between(query.getFechaInicio(), query.getFechaFin()) + 1;
        if (days > 0 && indicator.getTotalFacturado().compareTo(BigDecimal.ZERO) > 0) {
            indicator.setPromedioVentaDiaria(
                    indicator.getTotalFacturado().divide(BigDecimal.valueOf(days), 2, RoundingMode.HALF_UP)
            );
        } else {
            indicator.setPromedioVentaDiaria(BigDecimal.ZERO);
        }

        // Plato más vendido
        List<RankingItemDto> topDishes = getTopDishesRanking(query);
        if (!topDishes.isEmpty()) {
            indicator.setPlatoMasVendido(topDishes.get(0).getDescripcion());
        }

        // Sede con más ventas
        String sedeSql = "SELECT s.sede_nombre FROM pedido_detalle pd " +
                "INNER JOIN pedido pe ON pe.ped_id = pd.ped_id " +
                "INNER JOIN sede s ON s.sede_id = pe.sede_id " +
                "WHERE pe.ped_fecha BETWEEN :fechaInicio AND :fechaFin " +
                "GROUP BY s.sede_id, s.sede_nombre " +
                "ORDER BY SUM(pd.ped_det_cant * pd.ped_det_precio) DESC LIMIT 1";

        Query sedeQuery = entityManager.createNativeQuery(sedeSql);
        sedeQuery.setParameter("fechaInicio", query.getFechaInicio());
        sedeQuery.setParameter("fechaFin", query.getFechaFin());

        @SuppressWarnings("unchecked")
        List<Object> sedeResults = sedeQuery.getResultList();
        if (!sedeResults.isEmpty()) {
            indicator.setSedeMasVentas((String) sedeResults.get(0));
        }

        return indicator;
    }

    @Override
    public List<ReportDetailItemDto> getDetailByDishIds(List<Long> plaIds, LocalDate fechaInicio,
                                                         LocalDate fechaFin, Long sedeId, Long usuId) {
        List<ReportDetailItemDto> allDetails = new ArrayList<>();

        // Detalle desde recibos de caja (facturas)
        StringBuilder rcSql = new StringBuilder();
        rcSql.append("SELECT rc.rc_num, rc.rc_fecha, ");
        rcSql.append("CONCAT(c.cli_nombre, ' ', c.cli_apellidos) AS cliente, ");
        rcSql.append("CONCAT('RC-', rc.rc_num) AS documento, ");
        rcSql.append("rc.rc_total, p.pla_descripcion, rcd.rcd_cantidad, ");
        rcSql.append("s.sede_nombre, CONCAT(u.usu_nombre, ' ', u.usu_apellido) AS mesero ");
        rcSql.append("FROM recibo_caja_detalle rcd ");
        rcSql.append("INNER JOIN recibo_caja rc ON rc.rc_num = rcd.rc_num ");
        rcSql.append("INNER JOIN plato p ON p.pla_id = rcd.pla_id ");
        rcSql.append("INNER JOIN sede s ON s.sede_id = rc.sede_id ");
        rcSql.append("INNER JOIN usuario u ON u.usu_id = rc.usu_id ");
        rcSql.append("LEFT JOIN cliente c ON c.cli_id = rc.cli_id ");
        rcSql.append("WHERE rcd.pla_id IN (:plaIds) ");
        rcSql.append("AND rc.rc_fecha BETWEEN :fechaInicio AND :fechaFin ");

        if (sedeId != null) {
            rcSql.append("AND rc.sede_id = :sedeId ");
        }
        if (usuId != null) {
            rcSql.append("AND rc.usu_id = :usuId ");
        }

        rcSql.append("ORDER BY rc.rc_fecha DESC");

        Query rcQuery = entityManager.createNativeQuery(rcSql.toString());
        rcQuery.setParameter("plaIds", plaIds);
        rcQuery.setParameter("fechaInicio", fechaInicio);
        rcQuery.setParameter("fechaFin", fechaFin);
        if (sedeId != null) rcQuery.setParameter("sedeId", sedeId);
        if (usuId != null) rcQuery.setParameter("usuId", usuId);

        @SuppressWarnings("unchecked")
        List<Object[]> rcResults = rcQuery.getResultList();

        for (Object[] row : rcResults) {
            ReportDetailItemDto item = new ReportDetailItemDto();
            item.setTipoDocumento("RECIBO_CAJA");
            item.setDocumentoId(toLong(row[0]));
            item.setFecha(row[1] != null ? LocalDate.parse(row[1].toString()) : null);
            item.setCliente(row[2] != null ? (String) row[2] : "Sin cliente");
            item.setDocumento((String) row[3]);
            item.setTotal(toBigDecimal(row[4]));
            item.setPlatoDescripcion((String) row[5]);
            item.setCantidad(toInteger(row[6]));
            item.setSedeNombre((String) row[7]);
            item.setMesero((String) row[8]);
            allDetails.add(item);
        }

        // Detalle desde pedidos
        StringBuilder pedSql = new StringBuilder();
        pedSql.append("SELECT pe.ped_id, pe.ped_fecha, ");
        pedSql.append("'N/A' AS cliente, ");
        pedSql.append("CONCAT('PED-', pe.ped_id) AS documento, ");
        pedSql.append("SUM(pd.ped_det_cant * pd.ped_det_precio) AS total, ");
        pedSql.append("p.pla_descripcion, pd.ped_det_cant, ");
        pedSql.append("s.sede_nombre, CONCAT(u.usu_nombre, ' ', u.usu_apellido) AS mesero ");
        pedSql.append("FROM pedido_detalle pd ");
        pedSql.append("INNER JOIN pedido pe ON pe.ped_id = pd.ped_id ");
        pedSql.append("INNER JOIN plato p ON p.pla_id = pd.pla_id ");
        pedSql.append("INNER JOIN sede s ON s.sede_id = pe.sede_id ");
        pedSql.append("INNER JOIN usuario u ON u.usu_id = pe.usu_id ");
        pedSql.append("LEFT JOIN recibo_caja rc ON rc.ped_id = pe.ped_id ");
        pedSql.append("WHERE pd.pla_id IN (:plaIds) ");
        pedSql.append("AND pe.ped_fecha BETWEEN :fechaInicio AND :fechaFin ");
        pedSql.append("AND rc.rc_num IS NULL ");

        if (sedeId != null) {
            pedSql.append("AND pe.sede_id = :sedeId ");
        }
        if (usuId != null) {
            pedSql.append("AND pe.usu_id = :usuId ");
        }

        pedSql.append("GROUP BY pe.ped_id, pe.ped_fecha, p.pla_descripcion, pd.ped_det_cant, ");
        pedSql.append("s.sede_nombre, u.usu_nombre, u.usu_apellido ");
        pedSql.append("ORDER BY pe.ped_fecha DESC");

        Query pedQuery = entityManager.createNativeQuery(pedSql.toString());
        pedQuery.setParameter("plaIds", plaIds);
        pedQuery.setParameter("fechaInicio", fechaInicio);
        pedQuery.setParameter("fechaFin", fechaFin);
        if (sedeId != null) pedQuery.setParameter("sedeId", sedeId);
        if (usuId != null) pedQuery.setParameter("usuId", usuId);

        @SuppressWarnings("unchecked")
        List<Object[]> pedResults = pedQuery.getResultList();

        for (Object[] row : pedResults) {
            ReportDetailItemDto item = new ReportDetailItemDto();
            item.setTipoDocumento("PEDIDO");
            item.setDocumentoId(toLong(row[0]));
            item.setFecha(row[1] != null ? LocalDate.parse(row[1].toString()) : null);
            item.setCliente((String) row[2]);
            item.setDocumento((String) row[3]);
            item.setTotal(toBigDecimal(row[4]));
            item.setPlatoDescripcion((String) row[5]);
            item.setCantidad(toInteger(row[6]));
            item.setSedeNombre((String) row[7]);
            item.setMesero((String) row[8]);
            allDetails.add(item);
        }

        return allDetails;
    }

    private void appendOptionalFilters(StringBuilder sql, ReportQuery query) {
        if (query.getUsuId() != null) {
            sql.append("AND pe.usu_id = :usuId ");
        }
        if (query.getPlaId() != null) {
            sql.append("AND pd.pla_id = :plaId ");
        }
        if (query.getEstId() != null) {
            sql.append("AND pe.est_id = :estId ");
        }
        if (query.getSedeId() != null) {
            sql.append("AND pe.sede_id = :sedeId ");
        }
    }

    private void setCommonParameters(Query nativeQuery, ReportQuery query) {
        nativeQuery.setParameter("fechaInicio", query.getFechaInicio());
        nativeQuery.setParameter("fechaFin", query.getFechaFin());
        if (query.getUsuId() != null) {
            nativeQuery.setParameter("usuId", query.getUsuId());
        }
        if (query.getPlaId() != null) {
            nativeQuery.setParameter("plaId", query.getPlaId());
        }
        if (query.getEstId() != null) {
            nativeQuery.setParameter("estId", query.getEstId());
        }
        if (query.getSedeId() != null) {
            nativeQuery.setParameter("sedeId", query.getSedeId());
        }
    }

    private Long toLong(Object value) {
        if (value == null) return null;
        return ((Number) value).longValue();
    }

    private Integer toInteger(Object value) {
        if (value == null) return null;
        return ((Number) value).intValue();
    }

    private BigDecimal toBigDecimal(Object value) {
        if (value == null) return BigDecimal.ZERO;
        if (value instanceof BigDecimal) return (BigDecimal) value;
        return new BigDecimal(value.toString());
    }
}
