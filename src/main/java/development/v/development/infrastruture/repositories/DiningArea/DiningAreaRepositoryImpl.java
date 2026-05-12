package development.v.development.infrastruture.repositories.DiningArea;

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
import development.v.development.domain.models.DiningArea;
import development.v.development.domain.repositories.DiningAreaRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.DiningAreaEntity;
import development.v.development.infrastruture.mappers.DiningAreaMapper;

@Repository
public class DiningAreaRepositoryImpl implements DiningAreaRepository {

    private final DiningAreaJpaRepository jpaRepository;

    public DiningAreaRepositoryImpl(DiningAreaJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public DiningArea save(DiningArea diningArea) {
        DiningAreaEntity entity = DiningAreaMapper.toEntity(diningArea);
        return DiningAreaMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<DiningArea> findById(Long id) {
        return jpaRepository.findById(id)
            .map(DiningAreaMapper::toDomain);
    }

    @Override
    public PaginatedResultDto<List<DiningArea>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<DiningAreaEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<DiningAreaEntity> result = jpaRepository.findAll(spec, pageable);

        List<DiningArea> data = result.getContent()
                .stream()
                .map(DiningAreaMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public DiningArea update(DiningArea diningArea) {
        DiningAreaEntity entity = DiningAreaMapper.toEntity(diningArea);
        return DiningAreaMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
