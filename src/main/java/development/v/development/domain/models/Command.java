package development.v.development.domain.models;

public class Command {
    private Integer comId;
    private Integer mesa;
    private Integer plaId;
    private String comObs;
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

