package development.v.development.application.features.Dashboard.GetDashboard.Dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDetailResponseDto {

    private Integer facturaId;
    private Integer pedidoId;
    private LocalDate fecha;
    private String cliente;
    private String mesero;
    private String sede;
    private String estado;
    private BigDecimal totalFactura = BigDecimal.ZERO;
    private List<InvoiceLineDto> detalle = new ArrayList<>();

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

    public BigDecimal getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(BigDecimal totalFactura) {
        this.totalFactura = totalFactura;
    }

    public List<InvoiceLineDto> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<InvoiceLineDto> detalle) {
        this.detalle = detalle;
    }

    public static class InvoiceLineDto {
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

