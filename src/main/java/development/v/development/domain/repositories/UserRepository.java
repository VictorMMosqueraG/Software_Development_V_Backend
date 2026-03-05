package development.v.development.domain.repositories;

import java.util.Optional;

import development.v.development.domain.models.User;

public interface UserRepository {
    Optional<User> findById(Integer usuId);
}
