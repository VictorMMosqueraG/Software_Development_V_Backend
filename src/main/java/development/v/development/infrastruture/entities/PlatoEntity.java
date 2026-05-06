package development.v.development.infrastruture.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "plato")
public class PlatoEntity {

    @Id
    @Column(name = "pla_id")
    private Long plaId;

    @Column(name = "pla_descripcion", length = 40)
    private String plaDescripcion;

    @Column(name = "pla_precio")
    private BigDecimal plaPrecio;

    public Long getPlaId() { return plaId; }
    public void setPlaId(Long plaId) { this.plaId = plaId; }
    public String getPlaDescripcion() { return plaDescripcion; }
    public void setPlaDescripcion(String plaDescripcion) { this.plaDescripcion = plaDescripcion; }
    public BigDecimal getPlaPrecio() { return plaPrecio; }
    public void setPlaPrecio(BigDecimal plaPrecio) { this.plaPrecio = plaPrecio; }
}
