package development.v.development.application.features.User.GetUserById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.User;
import development.v.development.domain.repositories.UserRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetUserByIdUseCase {
    private final UserRepository userRepository;

    public GetUserByIdUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public DataResultDto<User> execute(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        return DataResultDto.success(
                user,
                Message.SUCCESS);
    }
}
