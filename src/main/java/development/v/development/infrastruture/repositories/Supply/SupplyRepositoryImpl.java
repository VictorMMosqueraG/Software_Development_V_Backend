package development.v.development.infrastruture.repositories.Supply;

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
import development.v.development.domain.models.Supply;
import development.v.development.domain.repositories.SupplyRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.SupplyEntity;
import development.v.development.infrastruture.mappers.SupplyMapper;

@Repository
public class SupplyRepositoryImpl implements SupplyRepository {

    private final SupplyJpaRepository jpaRepository;

    public SupplyRepositoryImpl(SupplyJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Supply save(Supply supply) {
        SupplyEntity entity = SupplyMapper.toEntity(supply);
        return SupplyMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Supply> findById(Long id) {
        return jpaRepository.findById(id)
            .map(SupplyMapper::toDomain);
    }

    @Override
    public PaginatedResultDto<List<Supply>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<SupplyEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<SupplyEntity> result = jpaRepository.findAll(spec, pageable);

        List<Supply> data = result.getContent()
                .stream()
                .map(SupplyMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public Supply update(Supply supply) {
        SupplyEntity entity = SupplyMapper.toEntity(supply);
        return SupplyMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
