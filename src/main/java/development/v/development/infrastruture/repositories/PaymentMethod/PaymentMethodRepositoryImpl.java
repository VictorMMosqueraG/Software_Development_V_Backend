package development.v.development.infrastruture.repositories.PaymentMethod;

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
import development.v.development.domain.models.PaymentMethod;
import development.v.development.domain.repositories.PaymentMethodRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.PaymentMethodEntity;
import development.v.development.infrastruture.mappers.PaymentMethodMapper;

@Repository
public class PaymentMethodRepositoryImpl implements PaymentMethodRepository {

    private final PaymentMethodJpaRepository jpaRepository;

    public PaymentMethodRepositoryImpl(PaymentMethodJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        PaymentMethodEntity entity = PaymentMethodMapper.toEntity(paymentMethod);
        return PaymentMethodMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<PaymentMethod> findById(Long id) {
        return jpaRepository.findById(id).map(PaymentMethodMapper::toDomain);
    }

    @Override
    public PaginatedResultDto<List<PaymentMethod>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<PaymentMethodEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<PaymentMethodEntity> result = jpaRepository.findAll(spec, pageable);

        List<PaymentMethod> data = result.getContent()
                .stream()
                .map(PaymentMethodMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public PaymentMethod update(PaymentMethod paymentMethod) {
        PaymentMethodEntity entity = PaymentMethodMapper.toEntity(paymentMethod);
        return PaymentMethodMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
