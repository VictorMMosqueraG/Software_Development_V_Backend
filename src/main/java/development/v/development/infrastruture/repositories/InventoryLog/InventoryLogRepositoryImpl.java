package development.v.development.infrastruture.repositories.InventoryLog;

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
import development.v.development.domain.models.InventoryLog;
import development.v.development.domain.repositories.InventoryLogRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.InventoryLogEntity;
import development.v.development.infrastruture.mappers.InventoryLogMapper;

@Repository
public class InventoryLogRepositoryImpl implements InventoryLogRepository {

    private final InventoryLogJpaRepository jpaRepository;

    public InventoryLogRepositoryImpl(InventoryLogJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public InventoryLog save(InventoryLog inventoryLog) {
        InventoryLogEntity entity = InventoryLogMapper.toEntity(inventoryLog);
        return InventoryLogMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<InventoryLog> findById(Long id) {
        return jpaRepository.findById(id)
            .map(InventoryLogMapper::toDomain);
    }

    @Override
    public PaginatedResultDto<List<InventoryLog>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<InventoryLogEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<InventoryLogEntity> result = jpaRepository.findAll(spec, pageable);

        List<InventoryLog> data = result.getContent()
                .stream()
                .map(InventoryLogMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public InventoryLog update(InventoryLog inventoryLog) {
        InventoryLogEntity entity = InventoryLogMapper.toEntity(inventoryLog);
        return InventoryLogMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
