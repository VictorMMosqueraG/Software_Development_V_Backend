package development.v.development.infrastruture.repositories.Status;

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
import development.v.development.domain.models.Status;
import development.v.development.domain.repositories.StatusRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.StatusEntity;
import development.v.development.infrastruture.mappers.StatusMapper;

@Repository
public class StatusRepositoryImpl implements StatusRepository {

    private final StatusJpaRepository jpaRepository;

    public StatusRepositoryImpl(StatusJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Status save(Status status) {
        StatusEntity entity = StatusMapper.toEntity(status);
        return StatusMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Status> findById(Long id) {
        return jpaRepository.findById(id)
            .map(StatusMapper::toDomain);
    }

    @Override
    public PaginatedResultDto<List<Status>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<StatusEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<StatusEntity> result = jpaRepository.findAll(spec, pageable);

        List<Status> data = result.getContent()
                .stream()
                .map(StatusMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public Status update(Status status) {
        StatusEntity entity = StatusMapper.toEntity(status);
        return StatusMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
