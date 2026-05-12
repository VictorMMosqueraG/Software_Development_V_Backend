package development.v.development.application.features.User.GetAllUser;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.User.GetAllUser.Dtos.GetAllUserQuery;
import development.v.development.application.features.User.GetAllUser.Mappers.GetAllUserMapper;
import development.v.development.domain.models.User;
import development.v.development.domain.repositories.UserRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllUserUseCase {

    private final UserRepository repository;

    public GetAllUserUseCase(UserRepository userRepository) {
        this.repository = userRepository;
    }

    public PaginatedResultDto<List<User>> execute(GetAllUserQuery query) {
        return repository.findAllPaginated(GetAllUserMapper.toFilter(query));
    }
}
