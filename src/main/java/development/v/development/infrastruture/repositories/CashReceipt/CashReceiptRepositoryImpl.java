package development.v.development.infrastruture.repositories.CashReceipt;

import java.util.List;
import java.util.Map;
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
import development.v.development.domain.models.CashReceipt;
import development.v.development.domain.repositories.CashReceiptRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.CashReceiptEntity;
import development.v.development.infrastruture.mappers.CashReceiptMapper;

@Repository
public class CashReceiptRepositoryImpl implements CashReceiptRepository {

    private final CashReceipJpaRepository jpaRepository;

    public CashReceiptRepositoryImpl(CashReceipJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public CashReceipt save(CashReceipt cashReceipt) {
        CashReceiptEntity entity = CashReceiptMapper.toEntity(cashReceipt);
        return CashReceiptMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public PaginatedResultDto<List<CashReceipt>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<CashReceiptEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<CashReceiptEntity> result = jpaRepository.findAll(spec, pageable);

        List<CashReceipt> data = result.getContent()
                .stream()
                .map(CashReceiptMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

}