package development.v.development.application.features.Dashboard.GetDashboard.Dtos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DashboardResponseDto {

    private List<TopDishItemDto> top5Platos = new ArrayList<>();
    private List<SedeMesItemDto> consolidadoPlatosPorSede = new ArrayList<>();
    private List<MeseroAtencionItemDto> consolidadoAtencionMeseros = new ArrayList<>();

    public List<TopDishItemDto> getTop5Platos() {
        return top5Platos;
    }

    public void setTop5Platos(List<TopDishItemDto> top5Platos) {
        this.top5Platos = top5Platos;
    }

    public List<SedeMesItemDto> getConsolidadoPlatosPorSede() {
        return consolidadoPlatosPorSede;
    }

    public void setConsolidadoPlatosPorSede(List<SedeMesItemDto> consolidadoPlatosPorSede) {
        this.consolidadoPlatosPorSede = consolidadoPlatosPorSede;
    }

    public List<MeseroAtencionItemDto> getConsolidadoAtencionMeseros() {
        return consolidadoAtencionMeseros;
    }

    public void setConsolidadoAtencionMeseros(List<MeseroAtencionItemDto> consolidadoAtencionMeseros) {
        this.consolidadoAtencionMeseros = consolidadoAtencionMeseros;
    }

    public static class TopDishItemDto {
        private Integer codigo;
        private String descripcion;
        private Long cantidad;
        private BigDecimal valor;

        public Integer getCodigo() {
            return codigo;
        }

        public void setCodigo(Integer codigo) {
            this.codigo = codigo;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public Long getCantidad() {
            return cantidad;
        }

        public void setCantidad(Long cantidad) {
            this.cantidad = cantidad;
        }

        public BigDecimal getValor() {
            return valor;
        }

        public void setValor(BigDecimal valor) {
            this.valor = valor;
        }
    }

    public static class SedeMesItemDto {
        private String anioMes;
        private String sede;
        private Long cantidad;
        private BigDecimal valor;

        public String getAnioMes() {
            return anioMes;
        }

        public void setAnioMes(String anioMes) {
            this.anioMes = anioMes;
        }

        public String getSede() {
            return sede;
        }

        public void setSede(String sede) {
            this.sede = sede;
        }

        public Long getCantidad() {
            return cantidad;
        }

        public void setCantidad(Long cantidad) {
            this.cantidad = cantidad;
        }

        public BigDecimal getValor() {
            return valor;
        }

        public void setValor(BigDecimal valor) {
            this.valor = valor;
        }
    }

    public static class MeseroAtencionItemDto {
        private Integer meseroId;
        private String mesero;
        private Long platosAtendidos;
        private Long pedidosAtendidos;

        public Integer getMeseroId() {
            return meseroId;
        }

        public void setMeseroId(Integer meseroId) {
            this.meseroId = meseroId;
        }

        public String getMesero() {
            return mesero;
        }

        public void setMesero(String mesero) {
            this.mesero = mesero;
        }

        public Long getPlatosAtendidos() {
            return platosAtendidos;
        }

        public void setPlatosAtendidos(Long platosAtendidos) {
            this.platosAtendidos = platosAtendidos;
        }

        public Long getPedidosAtendidos() {
            return pedidosAtendidos;
        }

        public void setPedidosAtendidos(Long pedidosAtendidos) {
            this.pedidosAtendidos = pedidosAtendidos;
        }
    }
}

