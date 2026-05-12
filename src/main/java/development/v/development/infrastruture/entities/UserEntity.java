package development.v.development.infrastruture.entities;

import java.time.LocalDateTime;

import development.v.development.infrastruture.enums.UserStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "usuario")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Long usuId;

    @Column(name = "usu_nombre", nullable = false, length = 60)
    private String usuNombre;

    @Column(name = "usu_apellido", nullable = false, length = 60)
    private String usuApellido;

    @Column(name = "usu_direccion", nullable = false, length = 100)
    private String usuDireccion;

    @Column(name = "usu_telefono", nullable = false, length = 20)
    private String usuTelefono;

    @Column(name = "usu_correo", nullable = false, unique = true, length = 100)
    private String usuCorreo;

    @Column(name = "email_verified_at")
    private LocalDateTime emailVerifiedAt;

    @Column(name = "perf_id")
    private Long perfId;

    @Column(name = "usu_login", nullable = false, unique = true, length = 30)
    private String usuLogin;

    @Column(name = "usu_pass", nullable = false, length = 255)
    private String usuPass;

    @Column(name = "remember_token", length = 100)
    private String rememberToken;

    @Enumerated(EnumType.STRING)
    @Column(name = "usu_estado", nullable = false)
    private UserStatus usuEstado;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
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
    public UserStatus getUsuEstado() { return usuEstado; }
    public void setUsuEstado(UserStatus usuEstado) { this.usuEstado = usuEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
