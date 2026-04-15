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

import java.time.LocalDate;

@Entity
@Table(name = "pedido")
public class OrderEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ped_id")
    private Integer pedId;

    @Column(name = "ped_fecha")
    private LocalDate pedFecha;

    @Column(name = "usu_id")
    private Integer usuId;

    @Column(name = "ped_mesa", length = 4)
    private String pedMesa;

    @Column(name = "est_id")
    private Integer estId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usu_id", insertable = false, updatable = false)
    private UserEntity usuario;

    public Integer getPedId() { return pedId; }
    public void setPedId(Integer pedId) { this.pedId = pedId; }

    public LocalDate getPedFecha() { return pedFecha; }
    public void setPedFecha(LocalDate pedFecha) { this.pedFecha = pedFecha; }

    public Integer getUsuId() { return usuId; }
    public void setUsuId(Integer usuId) { this.usuId = usuId; }

    public String getPedMesa() { return pedMesa; }
    public void setPedMesa(String pedMesa) { this.pedMesa = pedMesa; }

    public Integer getEstId() { return estId; }
    public void setEstId(Integer estId) { this.estId = estId; }

    public UserEntity getUsuario() { return usuario; }
    public void setUsuario(UserEntity usuario) { this.usuario = usuario; }
}
