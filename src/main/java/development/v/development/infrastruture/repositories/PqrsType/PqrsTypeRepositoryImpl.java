package development.v.development.infrastruture.repositories.PqrsType;

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
import development.v.development.domain.models.PqrsType;
import development.v.development.domain.repositories.PqrsTypeRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.PqrsTypeEntity;
import development.v.development.infrastruture.mappers.PqrsTypeMapper;

@Repository
public class PqrsTypeRepositoryImpl implements PqrsTypeRepository {

    private final PqrsTypeJpaRepository jpaRepository;

    public PqrsTypeRepositoryImpl(PqrsTypeJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public PqrsType save(PqrsType pqrsType) {
        PqrsTypeEntity entity = PqrsTypeMapper.toEntity(pqrsType);
        return PqrsTypeMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<PqrsType> findById(Long id) {
        return jpaRepository.findById(id).map(PqrsTypeMapper::toDomain);
    }

    @Override
    public PaginatedResultDto<List<PqrsType>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<PqrsTypeEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<PqrsTypeEntity> result = jpaRepository.findAll(spec, pageable);

        List<PqrsType> data = result.getContent()
                .stream()
                .map(PqrsTypeMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public PqrsType update(PqrsType pqrsType) {
        PqrsTypeEntity entity = PqrsTypeMapper.toEntity(pqrsType);
        return PqrsTypeMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
