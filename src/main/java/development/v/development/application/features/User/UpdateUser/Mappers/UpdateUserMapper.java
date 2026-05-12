package development.v.development.application.features.User.UpdateUser.Mappers;

import development.v.development.application.features.User.UpdateUser.Dtos.UpdateUserRequest;
import development.v.development.domain.models.User;

public class UpdateUserMapper {

    public static User toDomain(Long id, UpdateUserRequest request) {
        User user = new User();
        user.setUsuId(id);
        user.setUsuNombre(request.getUsuNombre());
        user.setUsuApellido(request.getUsuApellido());
        user.setUsuDireccion(request.getUsuDireccion());
        user.setUsuTelefono(request.getUsuTelefono());
        user.setPerfId(request.getPerfId());
        user.setUsuEstado(request.getUsuEstado());
        return user;
    }
}
