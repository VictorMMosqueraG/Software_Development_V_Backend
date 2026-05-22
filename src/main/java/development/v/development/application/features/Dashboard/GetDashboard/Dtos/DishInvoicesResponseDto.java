package development.v.development.application.features.Dashboard.GetDashboard.Dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DishInvoicesResponseDto {

    private Long totalFacturas;
    private Long totalItems;
    private BigDecimal totalValor = BigDecimal.ZERO;
    private List<InvoiceSummaryDto> facturas = new ArrayList<>();

    public Long getTotalFacturas() {
        return totalFacturas;
    }

    public void setTotalFacturas(Long totalFacturas) {
        this.totalFacturas = totalFacturas;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    public BigDecimal getTotalValor() {
        return totalValor;
    }

    public void setTotalValor(BigDecimal totalValor) {
        this.totalValor = totalValor;
    }

    public List<InvoiceSummaryDto> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<InvoiceSummaryDto> facturas) {
        this.facturas = facturas;
    }

    public static class InvoiceSummaryDto {
        private Integer facturaId;
        private Integer pedidoId;
        private LocalDate fecha;
        private String cliente;
        private String mesero;
        private String sede;
        private String estado;
        private Long cantidadItemsSeleccionados;
        private BigDecimal valorItemsSeleccionados = BigDecimal.ZERO;
        private BigDecimal totalFactura = BigDecimal.ZERO;
        private List<InvoiceDishDto> platosSeleccionados = new ArrayList<>();

        public Integer getFacturaId() {
            return facturaId;
        }

        public void setFacturaId(Integer facturaId) {
            this.facturaId = facturaId;
        }

        public Integer getPedidoId() {
            return pedidoId;
        }

        public void setPedidoId(Integer pedidoId) {
            this.pedidoId = pedidoId;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

        public String getCliente() {
            return cliente;
        }

        public void setCliente(String cliente) {
            this.cliente = cliente;
        }

        public String getMesero() {
            return mesero;
        }

        public void setMesero(String mesero) {
            this.mesero = mesero;
        }

        public String getSede() {
            return sede;
        }

        public void setSede(String sede) {
            this.sede = sede;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public Long getCantidadItemsSeleccionados() {
            return cantidadItemsSeleccionados;
        }

        public void setCantidadItemsSeleccionados(Long cantidadItemsSeleccionados) {
            this.cantidadItemsSeleccionados = cantidadItemsSeleccionados;
        }

        public BigDecimal getValorItemsSeleccionados() {
            return valorItemsSeleccionados;
        }

        public void setValorItemsSeleccionados(BigDecimal valorItemsSeleccionados) {
            this.valorItemsSeleccionados = valorItemsSeleccionados;
        }

        public BigDecimal getTotalFactura() {
            return totalFactura;
        }

        public void setTotalFactura(BigDecimal totalFactura) {
            this.totalFactura = totalFactura;
        }

        public List<InvoiceDishDto> getPlatosSeleccionados() {
            return platosSeleccionados;
        }

        public void setPlatosSeleccionados(List<InvoiceDishDto> platosSeleccionados) {
            this.platosSeleccionados = platosSeleccionados;
        }
    }

    public static class InvoiceDishDto {
        private Integer platoId;
        private String plato;
        private Long cantidad;
        private BigDecimal precioUnitario;
        private BigDecimal subtotal;

        public Integer getPlatoId() {
            return platoId;
        }

        public void setPlatoId(Integer platoId) {
            this.platoId = platoId;
        }

        public String getPlato() {
            return plato;
        }

        public void setPlato(String plato) {
            this.plato = plato;
        }

        public Long getCantidad() {
            return cantidad;
        }

        public void setCantidad(Long cantidad) {
            this.cantidad = cantidad;
        }

        public BigDecimal getPrecioUnitario() {
            return precioUnitario;
        }

        public void setPrecioUnitario(BigDecimal precioUnitario) {
            this.precioUnitario = precioUnitario;
        }

        public BigDecimal getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(BigDecimal subtotal) {
            this.subtotal = subtotal;
        }
    }
}

