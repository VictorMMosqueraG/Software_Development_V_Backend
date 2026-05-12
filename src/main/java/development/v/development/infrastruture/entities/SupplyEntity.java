package development.v.development.infrastruture.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "insumo")
@EntityListeners(AuditingEntityListener.class)
public class SupplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ins_id")
    private Long insId;

    @Column(name = "sede_id", nullable = false)
    private Long sedeId;

    @Column(name = "cins_id", nullable = false)
    private Long cinsId;

    @Column(name = "pres_id", nullable = false)
    private Long presId;

    @Column(name = "ins_nombre", nullable = false, length = 150)
    private String insNombre;

    @Column(name = "ins_codigo", length = 30)
    private String insCodigo;

    @Column(name = "ins_codigo_barras", unique = true, length = 50)
    private String insCodigoBarras;

    @Column(name = "ins_precio_compra")
    private BigDecimal insPrecioCompra;

    @Column(name = "ins_stock", nullable = false)
    private BigDecimal insStock;

    @Column(name = "ins_stock_min", nullable = false)
    private BigDecimal insStockMin;

    @Column(name = "ins_vendible", nullable = false)
    private Integer insVendible;

    @Column(name = "ins_imagen", length = 255)
    private String insImagen;

    @Column(name = "ins_estado", nullable = false)
    private Integer insEstado;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
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
