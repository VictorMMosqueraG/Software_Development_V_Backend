package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.Command;
import development.v.development.domain.responses.PaginatedResultDto;

public interface CommandRepository {
    Command save(Command command);
    Optional<Command> findById(Integer comId);
    PaginatedResultDto<List<Command>> findAllPaginated(EntityFilter filter);
    Command update(Command command);
    void delete(Integer id);
    boolean existsById(Integer id);
}

