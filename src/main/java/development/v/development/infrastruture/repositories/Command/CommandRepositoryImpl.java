package development.v.development.infrastruture.repositories.Command;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import development.v.development.domain.dtos.PaginationDto;
import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Command;
import development.v.development.domain.repositories.CommandRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.CommandEntity;
import development.v.development.infrastruture.mappers.CommandMapper;

@Repository
public class CommandRepositoryImpl implements CommandRepository {

    private final CommandJpaRepository jpaRepository;

    public CommandRepositoryImpl(CommandJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Command save(Command command) {
        CommandEntity entity = CommandMapper.toEntity(command);
        return CommandMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Command> findById(Integer comId) {
        return jpaRepository.findById(comId)
                .map(CommandMapper::toDomain);
    }

    @Override
    public PaginatedResultDto<List<Command>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<CommandEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<CommandEntity> result = jpaRepository.findAll(spec, pageable);

        List<Command> data = result.getContent()
                .stream()
                .map(CommandMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public Command update(Command command) {
        CommandEntity entity = CommandMapper.toEntity(command);
        return CommandMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return jpaRepository.existsById(id);
    }
}

