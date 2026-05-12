package development.v.development.application.features.User.UpdateUser;

import org.springframework.stereotype.Service;

import development.v.development.application.features.User.UpdateUser.Dtos.UpdateUserRequest;
import development.v.development.application.features.User.UpdateUser.Mappers.UpdateUserMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.User;
import development.v.development.domain.repositories.UserRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateUserUseCase {
    private final UserRepository userRepository;

    public UpdateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public DataResultDto<User> execute(Long id, UpdateUserRequest request) {

        userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        User domain = UpdateUserMapper.toDomain(id, request);
        User updatedUser = userRepository.update(domain);

        return DataResultDto.success(
                updatedUser,
                Message.SUCCESS);
    }
}
