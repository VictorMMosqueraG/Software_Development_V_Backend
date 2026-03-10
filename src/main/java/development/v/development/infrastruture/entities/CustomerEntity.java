package development.v.development.infrastruture.entities;

import java.time.LocalDateTime;

import development.v.development.infrastruture.enums.CustomerStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "cliente")
@EntityListeners(AuditingEntityListener.class)
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
    private Long cliId;

    @Column(name = "cli_nombre", nullable = false, length = 60)
    private String cliNombre;

    @Column(name = "cli_apellidos", nullable = false, length = 60)
    private String cliApellidos;

    @Column(name = "cli_tipo_documento", nullable = false, length = 20)
    private String cliTipoDocumento;

    @Column(name = "cli_num_documento", unique = true, length = 30)
    private String cliNumDocumento;

    @Column(name = "cli_direccion", length = 100)
    private String cliDireccion;

    @Column(name = "cli_telefono", length = 20)
    private String cliTelefono;

    @Column(name = "cli_correo", unique = true, length = 100)
    private String cliCorreo;

    @Enumerated(EnumType.STRING)
    @Column(name = "cli_estado", nullable = false)
    private CustomerStatus cliEstado;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false )
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
    public CustomerStatus getCliEstado() { return cliEstado; }
    public void setCliEstado(CustomerStatus cliEstado) { this.cliEstado = cliEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}