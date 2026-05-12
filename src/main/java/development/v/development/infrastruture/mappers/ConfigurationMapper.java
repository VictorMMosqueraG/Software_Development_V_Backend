package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.Configuration;
import development.v.development.infrastruture.entities.ConfigurationEntity;

public class ConfigurationMapper {
    public static Configuration toDomain(ConfigurationEntity entity) {
        Configuration model = new Configuration();
        model.setCfgId(entity.getCfgId());
        model.setCfgClave(entity.getCfgClave());
        model.setCfgValor(entity.getCfgValor());
        model.setCreatedAt(entity.getCreatedAt());
        model.setUpdatedAt(entity.getUpdatedAt());
        return model;
    }

    public static ConfigurationEntity toEntity(Configuration model) {
        ConfigurationEntity entity = new ConfigurationEntity();
        entity.setCfgId(model.getCfgId());
        entity.setCfgClave(model.getCfgClave());
        entity.setCfgValor(model.getCfgValor());
        return entity;
    }
}
