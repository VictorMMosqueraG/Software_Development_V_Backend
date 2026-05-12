package development.v.development.application.features.Report.GetReportDetail.Dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Elemento de detalle/trazabilidad de un documento asociado")
public class ReportDetailItemDto {

    @Schema(description = "Tipo de documento (FACTURA, PEDIDO)")
    private String tipoDocumento;

    @Schema(description = "ID del documento")
    private Long documentoId;

    @Schema(description = "Fecha del documento")
    private LocalDate fecha;

    @Schema(description = "Nombre del cliente")
    private String cliente;

    @Schema(description = "Número/referencia del documento")
    private String documento;

    @Schema(description = "Total del documento")
    private BigDecimal total;

    @Schema(description = "Nombre del plato relacionado")
    private String platoDescripcion;

    @Schema(description = "Cantidad del plato en el documento")
    private Integer cantidad;

    @Schema(description = "Nombre de la sede")
    private String sedeNombre;

    @Schema(description = "Mesero que atendió")
    private String mesero;

    public ReportDetailItemDto() {}

    public String getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }
    public Long getDocumentoId() { return documentoId; }
    public void setDocumentoId(Long documentoId) { this.documentoId = documentoId; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
    public String getPlatoDescripcion() { return platoDescripcion; }
    public void setPlatoDescripcion(String platoDescripcion) { this.platoDescripcion = platoDescripcion; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public String getSedeNombre() { return sedeNombre; }
    public void setSedeNombre(String sedeNombre) { this.sedeNombre = sedeNombre; }
    public String getMesero() { return mesero; }
    public void setMesero(String mesero) { this.mesero = mesero; }
}
