package development.v.development.domain.models;

import java.time.LocalDateTime;

public class User {

    private Long usuId;
    private String usuNombre;
    private String usuApellido;
    private String usuDireccion;
    private String usuTelefono;
    private String usuCorreo;
    private LocalDateTime emailVerifiedAt;
    private Long perfId;
    private String usuLogin;
    private String usuPass;
    private String rememberToken;
    private String usuEstado;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Long getUsuId() { return usuId; }
    public void setUsuId(Long usuId) { this.usuId = usuId; }
    public String getUsuNombre() { return usuNombre; }
    public void setUsuNombre(String usuNombre) { this.usuNombre = usuNombre; }
    public String getUsuApellido() { return usuApellido; }
    public void setUsuApellido(String usuApellido) { this.usuApellido = usuApellido; }
    public String getUsuDireccion() { return usuDireccion; }
    public void setUsuDireccion(String usuDireccion) { this.usuDireccion = usuDireccion; }
    public String getUsuTelefono() { return usuTelefono; }
    public void setUsuTelefono(String usuTelefono) { this.usuTelefono = usuTelefono; }
    public String getUsuCorreo() { return usuCorreo; }
    public void setUsuCorreo(String usuCorreo) { this.usuCorreo = usuCorreo; }
    public LocalDateTime getEmailVerifiedAt() { return emailVerifiedAt; }
    public void setEmailVerifiedAt(LocalDateTime emailVerifiedAt) { this.emailVerifiedAt = emailVerifiedAt; }
    public Long getPerfId() { return perfId; }
    public void setPerfId(Long perfId) { this.perfId = perfId; }
    public String getUsuLogin() { return usuLogin; }
    public void setUsuLogin(String usuLogin) { this.usuLogin = usuLogin; }
    public String getUsuPass() { return usuPass; }
    public void setUsuPass(String usuPass) { this.usuPass = usuPass; }
    public String getRememberToken() { return rememberToken; }
    public void setRememberToken(String rememberToken) { this.rememberToken = rememberToken; }
    public String getUsuEstado() { return usuEstado; }
    public void setUsuEstado(String usuEstado) { this.usuEstado = usuEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
