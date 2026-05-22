package development.v.development.infrastruture.repositories.Dish;

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
import development.v.development.domain.models.Dish;
import development.v.development.domain.repositories.DishRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.DishEntity;
import development.v.development.infrastruture.mappers.DishMapper;

@Repository
public class DishRepositoryImpl implements DishRepository {

    private final DishJpaRepository jpaRepository;

    public DishRepositoryImpl(DishJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Dish save(Dish dish) {
        DishEntity entity = DishMapper.toEntity(dish);
        return DishMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Dish> findById(Integer id) {
        return jpaRepository.findById(id).map(DishMapper::toDomain);
    }

    @Override
    public PaginatedResultDto<List<Dish>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<DishEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<DishEntity> result = jpaRepository.findAll(spec, pageable);

        List<Dish> data = result.getContent()
                .stream()
                .map(DishMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public Dish update(Dish dish) {
        DishEntity entity = DishMapper.toEntity(dish);
        return DishMapper.toDomain(jpaRepository.save(entity));
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

