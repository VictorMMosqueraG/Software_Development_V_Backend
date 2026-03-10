package development.v.development.domain.models;

import java.time.LocalDateTime;

public class Customer {
    private Long cliId;
    private String cliNombre;
    private String cliApellidos;
    private String cliTipoDocumento;
    private String cliNumDocumento;
    private String cliDireccion;
    private String cliTelefono;
    private String cliCorreo;
    private String cliEstado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getCliId() { return cliId; }
    public void setCliId(Long cliId) { this.cliId = cliId; }
    public String getCliNombre() { return cliNombre; }
    public void setCliNombre(String cliNombre) { this.cliNombre = cliNombre; }
    public String getCliApellidos() { return cliApellidos; }
    public void setCliApellidos(String cliApellidos) { this.cliApellidos = cliApellidos; }
    public String getCliTipoDocumento() { return cliTipoDocumento; }
    public void setCliTipoDocumento(String cliTipoDocumento) { this.cliTipoDocumento = cliTipoDocumento; }
    public String getCliNumDocumento() { return cliNumDocumento; }
    public void setCliNumDocumento(String cliNumDocumento) { this.cliNumDocumento = cliNumDocumento; }
    public String getCliDireccion() { return cliDireccion; }
    public void setCliDireccion(String cliDireccion) { this.cliDireccion = cliDireccion; }
    public String getCliTelefono() { return cliTelefono; }
    public void setCliTelefono(String cliTelefono) { this.cliTelefono = cliTelefono; }
    public String getCliCorreo() { return cliCorreo; }
    public void setCliCorreo(String cliCorreo) { this.cliCorreo = cliCorreo; }
    public String getCliEstado() { return cliEstado; }
    public void setCliEstado(String cliEstado) { this.cliEstado = cliEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
