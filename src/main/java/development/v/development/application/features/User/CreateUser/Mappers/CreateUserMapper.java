package development.v.development.application.features.User.CreateUser.Mappers;

import development.v.development.application.features.User.CreateUser.Dtos.CreateUserRequestDto;
import development.v.development.domain.models.User;

public class CreateUserMapper {

    public static User toDomain(CreateUserRequestDto request) {
        User user = new User();
        user.setUsuNombre(request.getUsuNombre());
        user.setUsuApellido(request.getUsuApellido());
        user.setUsuDireccion(request.getUsuDireccion());
        user.setUsuTelefono(request.getUsuTelefono());
        user.setUsuCorreo(request.getUsuCorreo());
        user.setPerfId(request.getPerfId());
        user.setUsuLogin(request.getUsuLogin());
        user.setUsuPass(request.getUsuPass());
        user.setUsuEstado(request.getUsuEstado());
        return user;
    }
}
