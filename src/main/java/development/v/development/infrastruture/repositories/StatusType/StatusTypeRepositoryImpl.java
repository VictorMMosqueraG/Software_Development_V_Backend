package development.v.development.infrastruture.repositories.StatusType;

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
import development.v.development.domain.models.StatusType;
import development.v.development.domain.repositories.StatusTypeRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.StatusTypeEntity;
import development.v.development.infrastruture.mappers.StatusTypeMapper;

@Repository
public class StatusTypeRepositoryImpl implements StatusTypeRepository {

    private final StatusTypeJpaRepository jpaRepository;

    public StatusTypeRepositoryImpl(StatusTypeJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public StatusType save(StatusType statusType) {
        StatusTypeEntity entity = StatusTypeMapper.toEntity(statusType);
        return StatusTypeMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<StatusType> findById(Long id) {
        return jpaRepository.findById(id)
            .map(StatusTypeMapper::toDomain);
    }

    @Override
    public PaginatedResultDto<List<StatusType>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<StatusTypeEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<StatusTypeEntity> result = jpaRepository.findAll(spec, pageable);

        List<StatusType> data = result.getContent()
                .stream()
                .map(StatusTypeMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public StatusType update(StatusType statusType) {
        StatusTypeEntity entity = StatusTypeMapper.toEntity(statusType);
        return StatusTypeMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
