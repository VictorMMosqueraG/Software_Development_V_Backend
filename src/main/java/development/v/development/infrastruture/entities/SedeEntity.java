package development.v.development.infrastruture.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "sede")
public class SedeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sede_id")
    private Long sedeId;

    @Column(name = "sede_nombre", nullable = false, length = 120)
    private String sedeNombre;

    @Column(name = "sede_direccion", length = 200)
    private String sedeDireccion;

    @Column(name = "sede_telefono", length = 30)
    private String sedeTelefono;

    @Column(name = "sede_estado", nullable = false, length = 10)
    private String sedeEstado;

    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public String getSedeNombre() { return sedeNombre; }
    public void setSedeNombre(String sedeNombre) { this.sedeNombre = sedeNombre; }
    public String getSedeDireccion() { return sedeDireccion; }
    public void setSedeDireccion(String sedeDireccion) { this.sedeDireccion = sedeDireccion; }
    public String getSedeTelefono() { return sedeTelefono; }
    public void setSedeTelefono(String sedeTelefono) { this.sedeTelefono = sedeTelefono; }
    public String getSedeEstado() { return sedeEstado; }
    public void setSedeEstado(String sedeEstado) { this.sedeEstado = sedeEstado; }
}
