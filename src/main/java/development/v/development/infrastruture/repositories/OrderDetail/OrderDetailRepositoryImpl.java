package development.v.development.infrastruture.repositories.OrderDetail;

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
import development.v.development.domain.models.OrderDetail;
import development.v.development.domain.repositories.OrderDetailRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.OrderDetailEntity;
import development.v.development.infrastruture.mappers.OrderDetailMapper;

@Repository
public class OrderDetailRepositoryImpl implements OrderDetailRepository {

    private final OrderDetailJpaRepository jpaRepository;

    public OrderDetailRepositoryImpl(OrderDetailJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        OrderDetailEntity entity = OrderDetailMapper.toEntity(orderDetail);
        return OrderDetailMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<OrderDetail> findById(Integer pedDetId) {
        return jpaRepository.findById(pedDetId)
                .map(OrderDetailMapper::toDomain);
    }

    @Override
    public List<OrderDetail> findByPedId(Integer pedId) {
        return jpaRepository.findByPedId(pedId)
                .stream()
                .map(OrderDetailMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public PaginatedResultDto<List<OrderDetail>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<OrderDetailEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<OrderDetailEntity> result = jpaRepository.findAll(spec, pageable);

        List<OrderDetail> data = result.getContent()
                .stream()
                .map(OrderDetailMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public OrderDetail update(OrderDetail orderDetail) {
        OrderDetailEntity entity = OrderDetailMapper.toEntity(orderDetail);
        return OrderDetailMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return jpaRepository.existsById(id);
    }
}

