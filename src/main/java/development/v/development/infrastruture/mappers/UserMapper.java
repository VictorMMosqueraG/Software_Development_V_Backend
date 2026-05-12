package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.User;
import development.v.development.infrastruture.entities.UserEntity;
import development.v.development.infrastruture.enums.UserStatus;

public class UserMapper {

    public static User toDomain(UserEntity entity) {
        User model = new User();
        model.setUsuId(entity.getUsuId());
        model.setUsuNombre(entity.getUsuNombre());
        model.setUsuApellido(entity.getUsuApellido());
        model.setUsuDireccion(entity.getUsuDireccion());
        model.setUsuTelefono(entity.getUsuTelefono());
        model.setUsuCorreo(entity.getUsuCorreo());
        model.setEmailVerifiedAt(entity.getEmailVerifiedAt());
        model.setPerfId(entity.getPerfId());
        model.setUsuLogin(entity.getUsuLogin());
        model.setUsuPass(entity.getUsuPass());
        model.setRememberToken(entity.getRememberToken());
        model.setUsuEstado(entity.getUsuEstado() != null
                ? entity.getUsuEstado().name() : null);
        model.setCreatedAt(entity.getCreatedAt());
        model.setUpdatedAt(entity.getUpdatedAt());
        return model;
    }

    public static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setUsuId(user.getUsuId());
        entity.setUsuNombre(user.getUsuNombre());
        entity.setUsuApellido(user.getUsuApellido());
        entity.setUsuDireccion(user.getUsuDireccion());
        entity.setUsuTelefono(user.getUsuTelefono());
        entity.setUsuCorreo(user.getUsuCorreo());
        entity.setEmailVerifiedAt(user.getEmailVerifiedAt());
        entity.setPerfId(user.getPerfId());
        entity.setUsuLogin(user.getUsuLogin());
        entity.setUsuPass(user.getUsuPass());
        entity.setRememberToken(user.getRememberToken());
        if (user.getUsuEstado() != null) {
            entity.setUsuEstado(UserStatus
                    .valueOf(user.getUsuEstado()));
        }
        return entity;
    }
}
