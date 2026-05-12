package development.v.development.infrastruture.repositories.SupplyCategory;

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
import development.v.development.domain.models.SupplyCategory;
import development.v.development.domain.repositories.SupplyCategoryRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.SupplyCategoryEntity;
import development.v.development.infrastruture.mappers.SupplyCategoryMapper;

@Repository
public class SupplyCategoryRepositoryImpl implements SupplyCategoryRepository {

    private final SupplyCategoryJpaRepository jpaRepository;

    public SupplyCategoryRepositoryImpl(SupplyCategoryJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public SupplyCategory save(SupplyCategory supplyCategory) {
        SupplyCategoryEntity entity = SupplyCategoryMapper.toEntity(supplyCategory);
        return SupplyCategoryMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<SupplyCategory> findById(Long id) {
        return jpaRepository.findById(id)
            .map(SupplyCategoryMapper::toDomain);
    }

    @Override
    public PaginatedResultDto<List<SupplyCategory>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<SupplyCategoryEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<SupplyCategoryEntity> result = jpaRepository.findAll(spec, pageable);

        List<SupplyCategory> data = result.getContent()
                .stream()
                .map(SupplyCategoryMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public SupplyCategory update(SupplyCategory supplyCategory) {
        SupplyCategoryEntity entity = SupplyCategoryMapper.toEntity(supplyCategory);
        return SupplyCategoryMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
