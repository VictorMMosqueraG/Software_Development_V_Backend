package development.v.development.infrastruture.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "forma_pago")
public class FormaPagoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fp_id")
    private Long fpId;

    @Column(name = "fp_descripcion", nullable = false, length = 60)
    private String fpDescripcion;

    @Column(name = "fp_estado", nullable = false, length = 10)
    private String fpEstado;

    public Long getFpId() { return fpId; }
    public void setFpId(Long fpId) { this.fpId = fpId; }
    public String getFpDescripcion() { return fpDescripcion; }
    public void setFpDescripcion(String fpDescripcion) { this.fpDescripcion = fpDescripcion; }
    public String getFpEstado() { return fpEstado; }
    public void setFpEstado(String fpEstado) { this.fpEstado = fpEstado; }
}
