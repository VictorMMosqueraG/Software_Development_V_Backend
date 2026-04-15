package development.v.development.domain.models;

public class OrderDetail {
    private Integer pedDetId;
    private Integer pedDetCant;
    private Float pedDetPrecio;
    private String pedDetObser;
    private Integer plaId;
    private Integer pedId;
    private Integer estId;

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
}

