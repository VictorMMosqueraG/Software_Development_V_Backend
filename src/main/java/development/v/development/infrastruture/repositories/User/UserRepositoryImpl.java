package development.v.development.infrastruture.repositories.User;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import development.v.development.domain.models.User;
import development.v.development.domain.repositories.UserRepository;
import development.v.development.infrastruture.mappers.UserMapper;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository jpaRepository;

    public UserRepositoryImpl(UserJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<User> findById(Integer userId) {
        return jpaRepository.findById(userId)
                .map(UserMapper::toDomain);
    }
}
