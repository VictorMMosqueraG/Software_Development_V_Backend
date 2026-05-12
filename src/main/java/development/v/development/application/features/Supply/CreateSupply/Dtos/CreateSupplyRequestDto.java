package development.v.development.application.features.Supply.CreateSupply.Dtos;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Request para crear un insumo")
public class CreateSupplyRequestDto {

    @NotNull(message = "La sede es requerida")
    @Schema(description = "ID de la sede", example = "1")
    private Long sedeId;

    @NotNull(message = "La categoria de insumo es requerida")
    @Schema(description = "ID de la categoria de insumo", example = "1")
    private Long cinsId;

    @NotNull(message = "La presentacion es requerida")
    @Schema(description = "ID de la presentacion", example = "1")
    private Long presId;

    @NotBlank(message = "El nombre es requerido")
    @Size(max = 150, message = "El nombre no puede superar 150 caracteres")
    @Schema(description = "Nombre del insumo", example = "Leche entera")
    private String insNombre;

    @Size(max = 30, message = "El codigo no puede superar 30 caracteres")
    @Schema(description = "Codigo del insumo", example = "INS-001")
    private String insCodigo;

    @Size(max = 50, message = "El codigo de barras no puede superar 50 caracteres")
    @Schema(description = "Codigo de barras del insumo", example = "7701234567890")
    private String insCodigoBarras;

    @Schema(description = "Precio de compra", example = "5000.00")
    private BigDecimal insPrecioCompra;

    @NotNull(message = "El stock es requerido")
    @Schema(description = "Stock actual", example = "100.00")
    private BigDecimal insStock;

    @NotNull(message = "El stock minimo es requerido")
    @Schema(description = "Stock minimo", example = "10.00")
    private BigDecimal insStockMin;

    @NotNull(message = "El campo vendible es requerido")
    @Schema(description = "Indica si es vendible (1=si, 0=no)", example = "1")
    private Integer insVendible;

    @Size(max = 255, message = "La imagen no puede superar 255 caracteres")
    @Schema(description = "URL de la imagen", example = "https://example.com/image.png")
    private String insImagen;

    @NotNull(message = "El estado es requerido")
    @Schema(description = "Estado del insumo (1=activo, 0=inactivo)", example = "1")
    private Integer insEstado;

    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public Long getCinsId() { return cinsId; }
    public void setCinsId(Long cinsId) { this.cinsId = cinsId; }
    public Long getPresId() { return presId; }
    public void setPresId(Long presId) { this.presId = presId; }
    public String getInsNombre() { return insNombre; }
    public void setInsNombre(String insNombre) { this.insNombre = insNombre; }
    public String getInsCodigo() { return insCodigo; }
    public void setInsCodigo(String insCodigo) { this.insCodigo = insCodigo; }
    public String getInsCodigoBarras() { return insCodigoBarras; }
    public void setInsCodigoBarras(String insCodigoBarras) { this.insCodigoBarras = insCodigoBarras; }
    public BigDecimal getInsPrecioCompra() { return insPrecioCompra; }
    public void setInsPrecioCompra(BigDecimal insPrecioCompra) { this.insPrecioCompra = insPrecioCompra; }
    public BigDecimal getInsStock() { return insStock; }
    public void setInsStock(BigDecimal insStock) { this.insStock = insStock; }
    public BigDecimal getInsStockMin() { return insStockMin; }
    public void setInsStockMin(BigDecimal insStockMin) { this.insStockMin = insStockMin; }
    public Integer getInsVendible() { return insVendible; }
    public void setInsVendible(Integer insVendible) { this.insVendible = insVendible; }
    public String getInsImagen() { return insImagen; }
    public void setInsImagen(String insImagen) { this.insImagen = insImagen; }
    public Integer getInsEstado() { return insEstado; }
    public void setInsEstado(Integer insEstado) { this.insEstado = insEstado; }
}
