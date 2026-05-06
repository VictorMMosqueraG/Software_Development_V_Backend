package development.v.development.infrastruture.repositories.CashReceiptDetail;

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
import development.v.development.domain.models.CashReceiptDetail;
import development.v.development.domain.repositories.CashReceiptDetailRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.CashReceiptDetailEntity;
import development.v.development.infrastruture.mappers.CashReceiptDetailMapper;

@Repository
public class CashReceiptDetailRepositoryImpl implements CashReceiptDetailRepository {

    private final CashReceiptDetailJpaRepository jpaRepository;

    public CashReceiptDetailRepositoryImpl(CashReceiptDetailJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public CashReceiptDetail save(CashReceiptDetail detail) {
        CashReceiptDetailEntity entity = CashReceiptDetailMapper.toEntity(detail);
        return CashReceiptDetailMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public PaginatedResultDto<List<CashReceiptDetail>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<CashReceiptDetailEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<CashReceiptDetailEntity> result = jpaRepository.findAll(spec, pageable);

        List<CashReceiptDetail> data = result.getContent()
                .stream()
                .map(CashReceiptDetailMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public Optional<CashReceiptDetail> findById(Long id) {
        return jpaRepository.findById(id)
                .map(CashReceiptDetailMapper::toDomain);
    }

    @Override
    public CashReceiptDetail update(CashReceiptDetail detail) {
        CashReceiptDetailEntity entity = CashReceiptDetailMapper.toEntity(detail);
        return CashReceiptDetailMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
