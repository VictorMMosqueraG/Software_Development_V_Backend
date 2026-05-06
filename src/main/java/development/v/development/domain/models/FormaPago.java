package development.v.development.domain.models;

public class FormaPago {
    private Long fpId;
    private String fpDescripcion;
    private String fpEstado;

    public Long getFpId() { return fpId; }
    public void setFpId(Long fpId) { this.fpId = fpId; }
    public String getFpDescripcion() { return fpDescripcion; }
    public void setFpDescripcion(String fpDescripcion) { this.fpDescripcion = fpDescripcion; }
    public String getFpEstado() { return fpEstado; }
    public void setFpEstado(String fpEstado) { this.fpEstado = fpEstado; }
}
