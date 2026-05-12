package development.v.development.infrastruture.entities;

import java.time.LocalDateTime;

import development.v.development.infrastruture.enums.BranchStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "sede")
@EntityListeners(AuditingEntityListener.class)
public class BranchEntity {

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

    @Enumerated(EnumType.STRING)
    @Column(name = "sede_estado", nullable = false)
    private BranchStatus sedeEstado;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getSedeId() { return sedeId; }
    public void setSedeId(Long sedeId) { this.sedeId = sedeId; }
    public String getSedeNombre() { return sedeNombre; }
    public void setSedeNombre(String sedeNombre) { this.sedeNombre = sedeNombre; }
    public String getSedeDireccion() { return sedeDireccion; }
    public void setSedeDireccion(String sedeDireccion) { this.sedeDireccion = sedeDireccion; }
    public String getSedeTelefono() { return sedeTelefono; }
    public void setSedeTelefono(String sedeTelefono) { this.sedeTelefono = sedeTelefono; }
    public BranchStatus getSedeEstado() { return sedeEstado; }
    public void setSedeEstado(BranchStatus sedeEstado) { this.sedeEstado = sedeEstado; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
