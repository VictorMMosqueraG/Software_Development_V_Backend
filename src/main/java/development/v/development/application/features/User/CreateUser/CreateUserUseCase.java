package development.v.development.application.features.User.CreateUser;

import org.springframework.stereotype.Service;

import development.v.development.application.features.User.CreateUser.Dtos.CreateUserRequestDto;
import development.v.development.application.features.User.CreateUser.Mappers.CreateUserMapper;
import development.v.development.domain.exceptions.ConflictException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.User;
import development.v.development.domain.repositories.UserRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateUserUseCase {

    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public DataResultDto<User> execute(CreateUserRequestDto request) {

        validateRequest(request.getUsuCorreo(), request.getUsuLogin());

        User domain = CreateUserMapper.toDomain(request);
        userRepository.save(domain);

        return DataResultDto.success(domain, Message.SUCCESS);
    }

    private void validateRequest(String correo, String login) {
        if (userRepository.existsByUsuCorreo(correo)) {
            throw new ConflictException(Message.ALREADY_EXIST + " Correo");
        }

        if (userRepository.existsByUsuLogin(login)) {
            throw new ConflictException(Message.ALREADY_EXIST + " Login");
        }
    }
}
