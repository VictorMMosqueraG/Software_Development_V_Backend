package development.v.development.domain.models;

import java.time.LocalDateTime;

public class Configuration {
    private Long cfgId;
    private String cfgClave;
    private String cfgValor;
    private LocalDateTime createdAt;
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
