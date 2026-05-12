package development.v.development.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Supply {
    private Long insId;
    private Long sedeId;
    private Long cinsId;
    private Long presId;
    private String insNombre;
    private String insCodigo;
    private String insCodigoBarras;
    private BigDecimal insPrecioCompra;
    private BigDecimal insStock;
    private BigDecimal insStockMin;
    private Integer insVendible;
    private String insImagen;
    private Integer insEstado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getInsId() { return insId; }
    public void setInsId(Long insId) { this.insId = insId; }
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
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
