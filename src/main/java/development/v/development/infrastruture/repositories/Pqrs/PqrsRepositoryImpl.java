package development.v.development.infrastruture.repositories.Pqrs;

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
import development.v.development.domain.models.Pqrs;
import development.v.development.domain.repositories.PqrsRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.PqrsEntity;
import development.v.development.infrastruture.mappers.PqrsMapper;

@Repository
public class PqrsRepositoryImpl implements PqrsRepository {

    private final PqrsJpaRepository jpaRepository;

    public PqrsRepositoryImpl(PqrsJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Pqrs save(Pqrs pqrs) {
        PqrsEntity entity = PqrsMapper.toEntity(pqrs);
        return PqrsMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Pqrs> findById(Long id) {
        return jpaRepository.findById(id).map(PqrsMapper::toDomain);
    }

    @Override
    public PaginatedResultDto<List<Pqrs>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<PqrsEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<PqrsEntity> result = jpaRepository.findAll(spec, pageable);

        List<Pqrs> data = result.getContent()
                .stream()
                .map(PqrsMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public Pqrs update(Pqrs pqrs) {
        PqrsEntity entity = PqrsMapper.toEntity(pqrs);
        return PqrsMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
