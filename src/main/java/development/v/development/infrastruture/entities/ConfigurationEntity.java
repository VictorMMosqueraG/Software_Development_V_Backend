package development.v.development.infrastruture.entities;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "configuracion")
@EntityListeners(AuditingEntityListener.class)
public class ConfigurationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cfg_id")
    private Long cfgId;

    @Column(name = "cfg_clave", nullable = false, unique = true, length = 100)
    private String cfgClave;

    @Column(name = "cfg_valor", columnDefinition = "TEXT")
    private String cfgValor;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false, insertable = false)
    private LocalDateTime updatedAt;

    public Long getCfgId() { return cfgId; }
    public void setCfgId(Long cfgId) { this.cfgId = cfgId; }
    public String getCfgClave() { return cfgClave; }
    public void setCfgClave(String cfgClave) { this.cfgClave = cfgClave; }
    public String getCfgValor() { return cfgValor; }
    public void setCfgValor(String cfgValor) { this.cfgValor = cfgValor; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
