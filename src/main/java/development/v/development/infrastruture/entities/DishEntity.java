package development.v.development.infrastruture.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "plato")
public class DishEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pla_id")
    private Integer plaId;

    @Column(name = "pla_descripcion", length = 40)
    private String plaDescripcion;

    @Column(name = "pla_precio")
    private Float plaPrecio;

    @Column(name = "est_id")
    private Integer estId;

    @Column(name = "pla_imagen")
    private String plaImagen;

    public Integer getPlaId() { return plaId; }
    public void setPlaId(Integer plaId) { this.plaId = plaId; }

    public String getPlaDescripcion() { return plaDescripcion; }
    public void setPlaDescripcion(String plaDescripcion) { this.plaDescripcion = plaDescripcion; }

    public Float getPlaPrecio() { return plaPrecio; }
    public void setPlaPrecio(Float plaPrecio) { this.plaPrecio = plaPrecio; }

    public Integer getEstId() { return estId; }
    public void setEstId(Integer estId) { this.estId = estId; }

    public String getPlaImagen() { return plaImagen; }
    public void setPlaImagen(String plaImagen) { this.plaImagen = plaImagen; }
}

