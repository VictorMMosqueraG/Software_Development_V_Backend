package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.User;
import development.v.development.infrastruture.entities.UserEntity;

public class UserMapper {
    
    public static User toDomain(UserEntity entity) {
        User model = new User();
        model.setUsuId(entity.getUsuId());
        model.setUsuNombre(entity.getUsuNombre());
        return model;
    }
}
