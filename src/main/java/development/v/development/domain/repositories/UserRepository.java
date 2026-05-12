package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.User;
import development.v.development.domain.responses.PaginatedResultDto;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    PaginatedResultDto<List<User>> findAllPaginated(EntityFilter filter);
    User update(User user);
    void delete(Long id);

    boolean existsByUsuCorreo(String usuCorreo);
    boolean existsByUsuLogin(String usuLogin);
}
