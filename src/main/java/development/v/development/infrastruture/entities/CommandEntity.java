package development.v.development.infrastruture.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comanda")
public class CommandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id")
    private Integer comId;

    @Column(name = "mesa")
    private Integer mesa;

    @Column(name = "pla_id")
    private Integer plaId;

    @Column(name = "com_obs", length = 60)
    private String comObs;

    @Column(name = "est_id")
    private Integer estId;

    public Integer getComId() { return comId; }
    public void setComId(Integer comId) { this.comId = comId; }

    public Integer getMesa() { return mesa; }
    public void setMesa(Integer mesa) { this.mesa = mesa; }

    public Integer getPlaId() { return plaId; }
    public void setPlaId(Integer plaId) { this.plaId = plaId; }

    public String getComObs() { return comObs; }
    public void setComObs(String comObs) { this.comObs = comObs; }

    public Integer getEstId() { return estId; }
    public void setEstId(Integer estId) { this.estId = estId; }
}

