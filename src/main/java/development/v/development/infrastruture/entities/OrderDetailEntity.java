package development.v.development.infrastruture.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido_detalle")
public class OrderDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ped_det_id")
    private Integer pedDetId;

    @Column(name = "ped_det_cant")
    private Integer pedDetCant;

    @Column(name = "ped_det_precio")
    private Float pedDetPrecio;

    @Column(name = "ped_det_obser", length = 40)
    private String pedDetObser;

    @Column(name = "pla_id")
    private Integer plaId;

    @Column(name = "ped_id")
    private Integer pedId;

    @Column(name = "est_id")
    private Integer estId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ped_id", insertable = false, updatable = false)
    private OrderEntity pedido;

    public Integer getPedDetId() { return pedDetId; }
    public void setPedDetId(Integer pedDetId) { this.pedDetId = pedDetId; }

    public Integer getPedDetCant() { return pedDetCant; }
    public void setPedDetCant(Integer pedDetCant) { this.pedDetCant = pedDetCant; }

    public Float getPedDetPrecio() { return pedDetPrecio; }
    public void setPedDetPrecio(Float pedDetPrecio) { this.pedDetPrecio = pedDetPrecio; }

    public String getPedDetObser() { return pedDetObser; }
    public void setPedDetObser(String pedDetObser) { this.pedDetObser = pedDetObser; }

    public Integer getPlaId() { return plaId; }
    public void setPlaId(Integer plaId) { this.plaId = plaId; }

    public Integer getPedId() { return pedId; }
    public void setPedId(Integer pedId) { this.pedId = pedId; }

    public Integer getEstId() { return estId; }
    public void setEstId(Integer estId) { this.estId = estId; }

    public OrderEntity getPedido() { return pedido; }
    public void setPedido(OrderEntity pedido) { this.pedido = pedido; }
}

