package development.v.development.infrastruture.repositories.Dashboard;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import development.v.development.application.features.Dashboard.GetDashboard.Dtos.DashboardFiltersDto;
import development.v.development.application.features.Dashboard.GetDashboard.Dtos.DishInvoicesResponseDto;
import development.v.development.application.features.Dashboard.GetDashboard.Dtos.DashboardResponseDto;
import development.v.development.application.features.Dashboard.GetDashboard.Dtos.GetDishInvoicesQuery;
import development.v.development.application.features.Dashboard.GetDashboard.Dtos.GetDashboardQuery;
import development.v.development.application.features.Dashboard.GetDashboard.Dtos.InvoiceDetailResponseDto;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.repositories.DashboardRepository;

@Repository
public class DashboardRepositoryImpl implements DashboardRepository {

    private static final String DASHBOARD_SQL = """
            WITH base AS (
                SELECT
                    p.ped_id,
                    p.ped_fecha,
                    DATE_FORMAT(p.ped_fecha, '%Y-%m') AS anio_mes,
                    p.usu_id,
                    COALESCE(NULLIF(TRIM(u.usu_nombre), ''), CONCAT('Mesero ', p.usu_id)) AS mesero,
                    pd.pla_id,
                    pl.pla_descripcion AS plato,
                    p.est_id,
                    COALESCE(e.est_descripcion, CONCAT('Estado ', p.est_id)) AS estado,
                    p.ped_mesa AS sede,
                    pd.ped_det_cant AS cantidad,
                    pd.ped_det_precio AS precio_unitario,
                    (pd.ped_det_cant * pd.ped_det_precio) AS valor_linea
                FROM pedido p
                INNER JOIN pedido_detalle pd ON pd.ped_id = p.ped_id
                INNER JOIN plato pl ON pl.pla_id = pd.pla_id
                LEFT JOIN usuario u ON u.usu_id = p.usu_id
                LEFT JOIN estado e ON e.est_id = p.est_id
                WHERE
                    (:fecha_inicio IS NULL OR p.ped_fecha >= :fecha_inicio)
                    AND (:fecha_fin IS NULL OR p.ped_fecha <= :fecha_fin)
                    AND (:mesero_id IS NULL OR p.usu_id = :mesero_id)
                    AND (:plato_id IS NULL OR pd.pla_id = :plato_id)
                    AND (:estado_id IS NULL OR p.est_id = :estado_id)
                    AND (:sede IS NULL OR p.ped_mesa = :sede)
            )
            SELECT
                'TOP5' AS metric_type,
                CAST(t.pla_id AS CHAR) AS key1,
                t.plato AS key2,
                t.cantidad_total AS metric_1,
                t.venta_total AS metric_2
            FROM (
                SELECT
                    pla_id,
                    plato,
                    SUM(cantidad) AS cantidad_total,
                    ROUND(SUM(valor_linea), 2) AS venta_total
                FROM base
                GROUP BY pla_id, plato
                ORDER BY cantidad_total DESC, venta_total DESC
                LIMIT 5
            ) t
            UNION ALL
            SELECT
                'SEDE_MES' AS metric_type,
                b.anio_mes AS key1,
                b.sede AS key2,
                SUM(b.cantidad) AS metric_1,
                ROUND(SUM(b.valor_linea), 2) AS metric_2
            FROM base b
            GROUP BY b.anio_mes, b.sede
            UNION ALL
            SELECT
                'MESERO' AS metric_type,
                CAST(b.usu_id AS CHAR) AS key1,
                b.mesero AS key2,
                SUM(b.cantidad) AS metric_1,
                COUNT(DISTINCT b.ped_id) AS metric_2
            FROM base b
            GROUP BY b.usu_id, b.mesero
            ORDER BY metric_type, key1, key2
            """;

    private static final String FILTERS_SQL = """
            SELECT 'MESERO' AS tipo, CAST(usu_id AS CHAR) AS id, usu_nombre AS nombre
            FROM usuario
            WHERE usu_nombre IS NOT NULL AND TRIM(usu_nombre) <> ''
            UNION ALL
            SELECT 'PLATO' AS tipo, CAST(pla_id AS CHAR) AS id, pla_descripcion AS nombre
            FROM plato
            WHERE pla_descripcion IS NOT NULL AND TRIM(pla_descripcion) <> ''
            UNION ALL
            SELECT 'ESTADO' AS tipo, CAST(est_id AS CHAR) AS id, est_descripcion AS nombre
            FROM estado
            WHERE tes_id = 2 AND est_descripcion IS NOT NULL AND TRIM(est_descripcion) <> ''
            UNION ALL
            SELECT 'SEDE' AS tipo, ped_mesa AS id, ped_mesa AS nombre
            FROM pedido
            WHERE ped_mesa IS NOT NULL AND TRIM(ped_mesa) <> ''
            GROUP BY ped_mesa
            ORDER BY tipo, nombre
            """;

    private static final String INVOICES_BY_DISHES_SQL = """
            SELECT
                rc.rc_num AS factura_id,
                rc.ped_id AS pedido_id,
                rc.rc_fecha AS fecha,
                rc.rc_total AS total_factura,
                COALESCE(CONCAT(TRIM(c.cli_nombre), ' ', TRIM(c.cli_apellidos)), CONCAT('Cliente ', rc.cli_id)) AS cliente,
                COALESCE(CONCAT(TRIM(u.usu_nombre), ' ', TRIM(u.usu_apellido)), CONCAT('Mesero ', rc.usu_id)) AS mesero,
                p.ped_mesa AS sede,
                COALESCE(e.est_descripcion, CONCAT('Estado ', p.est_id)) AS estado,
                rcd.pla_id AS plato_id,
                pl.pla_descripcion AS plato,
                rcd.rcd_cantidad AS cantidad,
                rcd.rcd_precio AS precio_unitario,
                ROUND(rcd.rcd_cantidad * rcd.rcd_precio, 2) AS subtotal
            FROM recibo_caja rc
            INNER JOIN recibo_caja_detalle rcd ON rcd.rcd_num = rc.rc_num
            INNER JOIN plato pl ON pl.pla_id = rcd.pla_id
            LEFT JOIN pedido p ON p.ped_id = rc.ped_id
            LEFT JOIN cliente c ON c.cli_id = rc.cli_id
            LEFT JOIN usuario u ON u.usu_id = rc.usu_id
            LEFT JOIN estado e ON e.est_id = p.est_id
            WHERE
                (:fecha_inicio IS NULL OR rc.rc_fecha >= :fecha_inicio)
                AND (:fecha_fin IS NULL OR rc.rc_fecha <= :fecha_fin)
                AND (:mesero_id IS NULL OR rc.usu_id = :mesero_id)
                AND (:estado_id IS NULL OR p.est_id = :estado_id)
                AND (:sede IS NULL OR p.ped_mesa = :sede)
                AND (:has_platos = 0 OR rcd.pla_id IN (:plato_ids))
            ORDER BY rc.rc_num DESC, rcd.rcd_id ASC
            """;

    private static final String INVOICE_DETAIL_SQL = """
            SELECT
                rc.rc_num AS factura_id,
                rc.ped_id AS pedido_id,
                rc.rc_fecha AS fecha,
                rc.rc_total AS total_factura,
                COALESCE(CONCAT(TRIM(c.cli_nombre), ' ', TRIM(c.cli_apellidos)), CONCAT('Cliente ', rc.cli_id)) AS cliente,
                COALESCE(CONCAT(TRIM(u.usu_nombre), ' ', TRIM(u.usu_apellido)), CONCAT('Mesero ', rc.usu_id)) AS mesero,
                p.ped_mesa AS sede,
                COALESCE(e.est_descripcion, CONCAT('Estado ', p.est_id)) AS estado,
                rcd.pla_id AS plato_id,
                pl.pla_descripcion AS plato,
                rcd.rcd_cantidad AS cantidad,
                rcd.rcd_precio AS precio_unitario,
                ROUND(rcd.rcd_cantidad * rcd.rcd_precio, 2) AS subtotal
            FROM recibo_caja rc
            INNER JOIN recibo_caja_detalle rcd ON rcd.rcd_num = rc.rc_num
            INNER JOIN plato pl ON pl.pla_id = rcd.pla_id
            LEFT JOIN pedido p ON p.ped_id = rc.ped_id
            LEFT JOIN cliente c ON c.cli_id = rc.cli_id
            LEFT JOIN usuario u ON u.usu_id = rc.usu_id
            LEFT JOIN estado e ON e.est_id = p.est_id
            WHERE rc.rc_num = :factura_id
            ORDER BY rcd.rcd_id ASC
            """;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public DashboardRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public DashboardResponseDto getDashboard(GetDashboardQuery query) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("fecha_inicio", query.getFechaInicio())
                .addValue("fecha_fin", query.getFechaFin())
                .addValue("mesero_id", query.getMeseroId())
                .addValue("plato_id", query.getPlatoId())
                .addValue("estado_id", query.getEstadoId())
                .addValue("sede", normalizeSede(query.getSede()));

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(DASHBOARD_SQL, params);
        DashboardResponseDto response = new DashboardResponseDto();

        List<DashboardResponseDto.TopDishItemDto> top5 = new ArrayList<>();
        List<DashboardResponseDto.SedeMesItemDto> porSedeMes = new ArrayList<>();
        List<DashboardResponseDto.MeseroAtencionItemDto> porMesero = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            String metricType = toStringValue(row.get("metric_type"));

            if ("TOP5".equals(metricType)) {
                DashboardResponseDto.TopDishItemDto item = new DashboardResponseDto.TopDishItemDto();
                item.setCodigo(toInteger(row.get("key1")));
                item.setDescripcion(toStringValue(row.get("key2")));
                item.setCantidad(toLong(row.get("metric_1")));
                item.setValor(toBigDecimal(row.get("metric_2")));
                top5.add(item);
                continue;
            }

            if ("SEDE_MES".equals(metricType)) {
                DashboardResponseDto.SedeMesItemDto item = new DashboardResponseDto.SedeMesItemDto();
                item.setAnioMes(toStringValue(row.get("key1")));
                item.setSede(toStringValue(row.get("key2")));
                item.setCantidad(toLong(row.get("metric_1")));
                item.setValor(toBigDecimal(row.get("metric_2")));
                porSedeMes.add(item);
                continue;
            }

            if ("MESERO".equals(metricType)) {
                DashboardResponseDto.MeseroAtencionItemDto item = new DashboardResponseDto.MeseroAtencionItemDto();
                item.setMeseroId(toInteger(row.get("key1")));
                item.setMesero(toStringValue(row.get("key2")));
                item.setPlatosAtendidos(toLong(row.get("metric_1")));
                item.setPedidosAtendidos(toLong(row.get("metric_2")));
                porMesero.add(item);
            }
        }

        response.setTop5Platos(top5);
        response.setConsolidadoPlatosPorSede(porSedeMes);
        response.setConsolidadoAtencionMeseros(porMesero);
        return response;
    }

    @Override
    public DashboardFiltersDto getDashboardFilters() {
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(FILTERS_SQL, new MapSqlParameterSource());
        DashboardFiltersDto response = new DashboardFiltersDto();

        List<DashboardFiltersDto.CatalogItemDto> meseros = new ArrayList<>();
        List<DashboardFiltersDto.CatalogItemDto> platos = new ArrayList<>();
        List<DashboardFiltersDto.CatalogItemDto> estados = new ArrayList<>();
        List<DashboardFiltersDto.CatalogItemDto> sedes = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            String tipo = toStringValue(row.get("tipo"));
            DashboardFiltersDto.CatalogItemDto item = new DashboardFiltersDto.CatalogItemDto(
                    toStringValue(row.get("id")),
                    toStringValue(row.get("nombre")));

            if ("MESERO".equals(tipo)) {
                meseros.add(item);
                continue;
            }
            if ("PLATO".equals(tipo)) {
                platos.add(item);
                continue;
            }
            if ("ESTADO".equals(tipo)) {
                estados.add(item);
                continue;
            }
            if ("SEDE".equals(tipo)) {
                sedes.add(item);
            }
        }

        response.setMeseros(meseros);
        response.setPlatos(platos);
        response.setEstados(estados);
        response.setSedes(sedes);
        return response;
    }

    @Override
    public DishInvoicesResponseDto getInvoicesByDishes(GetDishInvoicesQuery query) {
        List<Integer> normalizedPlatoIds = normalizePlatoIds(query.getPlatoIds());
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("fecha_inicio", query.getFechaInicio())
                .addValue("fecha_fin", query.getFechaFin())
                .addValue("mesero_id", query.getMeseroId())
                .addValue("estado_id", query.getEstadoId())
                .addValue("sede", normalizeSede(query.getSede()))
                .addValue("has_platos", normalizedPlatoIds.isEmpty() ? 0 : 1)
                .addValue("plato_ids", normalizedPlatoIds.isEmpty() ? List.of(-1) : normalizedPlatoIds);

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(INVOICES_BY_DISHES_SQL, params);

        Map<Integer, DishInvoicesResponseDto.InvoiceSummaryDto> groupedInvoices = new LinkedHashMap<>();
        long totalItems = 0L;
        BigDecimal totalValor = BigDecimal.ZERO;

        for (Map<String, Object> row : rows) {
            Integer facturaId = toInteger(row.get("factura_id"));
            if (facturaId == null) {
                continue;
            }

            DishInvoicesResponseDto.InvoiceSummaryDto invoice = groupedInvoices.get(facturaId);
            if (invoice == null) {
                invoice = new DishInvoicesResponseDto.InvoiceSummaryDto();
                invoice.setFacturaId(facturaId);
                invoice.setPedidoId(toInteger(row.get("pedido_id")));
                invoice.setFecha(toLocalDate(row.get("fecha")));
                invoice.setCliente(toStringValue(row.get("cliente")));
                invoice.setMesero(toStringValue(row.get("mesero")));
                invoice.setSede(toStringValue(row.get("sede")));
                invoice.setEstado(toStringValue(row.get("estado")));
                invoice.setTotalFactura(toBigDecimal(row.get("total_factura")));
                invoice.setCantidadItemsSeleccionados(0L);
                invoice.setValorItemsSeleccionados(BigDecimal.ZERO);
                groupedInvoices.put(facturaId, invoice);
            }

            DishInvoicesResponseDto.InvoiceDishDto line = new DishInvoicesResponseDto.InvoiceDishDto();
            line.setPlatoId(toInteger(row.get("plato_id")));
            line.setPlato(toStringValue(row.get("plato")));
            line.setCantidad(toLong(row.get("cantidad")));
            line.setPrecioUnitario(toBigDecimal(row.get("precio_unitario")));
            line.setSubtotal(toBigDecimal(row.get("subtotal")));
            invoice.getPlatosSeleccionados().add(line);

            long cantidad = line.getCantidad() == null ? 0L : line.getCantidad();
            BigDecimal subtotal = line.getSubtotal() == null ? BigDecimal.ZERO : line.getSubtotal();

            invoice.setCantidadItemsSeleccionados(invoice.getCantidadItemsSeleccionados() + cantidad);
            invoice.setValorItemsSeleccionados(invoice.getValorItemsSeleccionados().add(subtotal));

            totalItems += cantidad;
            totalValor = totalValor.add(subtotal);
        }

        DishInvoicesResponseDto response = new DishInvoicesResponseDto();
        response.setFacturas(new ArrayList<>(groupedInvoices.values()));
        response.setTotalFacturas((long) groupedInvoices.size());
        response.setTotalItems(totalItems);
        response.setTotalValor(totalValor);
        return response;
    }

    @Override
    public InvoiceDetailResponseDto getInvoiceDetail(Integer facturaId) {
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("factura_id", facturaId);
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(INVOICE_DETAIL_SQL, params);

        if (rows.isEmpty()) {
            throw new NotFoundException(Message.NOT_FOUND);
        }

        Map<String, Object> first = rows.get(0);
        InvoiceDetailResponseDto response = new InvoiceDetailResponseDto();
        response.setFacturaId(toInteger(first.get("factura_id")));
        response.setPedidoId(toInteger(first.get("pedido_id")));
        response.setFecha(toLocalDate(first.get("fecha")));
        response.setCliente(toStringValue(first.get("cliente")));
        response.setMesero(toStringValue(first.get("mesero")));
        response.setSede(toStringValue(first.get("sede")));
        response.setEstado(toStringValue(first.get("estado")));
        response.setTotalFactura(toBigDecimal(first.get("total_factura")));

        List<InvoiceDetailResponseDto.InvoiceLineDto> lines = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            InvoiceDetailResponseDto.InvoiceLineDto line = new InvoiceDetailResponseDto.InvoiceLineDto();
            line.setPlatoId(toInteger(row.get("plato_id")));
            line.setPlato(toStringValue(row.get("plato")));
            line.setCantidad(toLong(row.get("cantidad")));
            line.setPrecioUnitario(toBigDecimal(row.get("precio_unitario")));
            line.setSubtotal(toBigDecimal(row.get("subtotal")));
            lines.add(line);
        }
        response.setDetalle(lines);
        return response;
    }

    private String normalizeSede(String sede) {
        if (sede == null) {
            return null;
        }
        String value = sede.trim();
        return value.isEmpty() ? null : value;
    }

    private List<Integer> normalizePlatoIds(List<Integer> platoIds) {
        if (platoIds == null || platoIds.isEmpty()) {
            return List.of();
        }
        Set<Integer> uniqueIds = platoIds.stream()
                .filter(id -> id != null && id > 0)
                .collect(Collectors.toSet());
        return new ArrayList<>(uniqueIds);
    }

    private Integer toInteger(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Number number) {
            return number.intValue();
        }
        String text = value.toString().trim();
        return text.isEmpty() ? null : Integer.valueOf(text);
    }

    private Long toLong(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Number number) {
            return number.longValue();
        }
        String text = value.toString().trim();
        return text.isEmpty() ? null : Long.valueOf(text);
    }

    private BigDecimal toBigDecimal(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof BigDecimal decimal) {
            return decimal;
        }
        if (value instanceof Number number) {
            return BigDecimal.valueOf(number.doubleValue());
        }
        String text = value.toString().trim();
        return text.isEmpty() ? null : new BigDecimal(text);
    }

    private String toStringValue(Object value) {
        return value == null ? null : value.toString();
    }

    private LocalDate toLocalDate(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof LocalDate localDate) {
            return localDate;
        }
        return LocalDate.parse(value.toString());
    }
}

