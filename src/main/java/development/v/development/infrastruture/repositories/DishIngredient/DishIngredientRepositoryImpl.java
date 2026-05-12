package development.v.development.infrastruture.repositories.DishIngredient;

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
import development.v.development.domain.models.DishIngredient;
import development.v.development.domain.repositories.DishIngredientRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.DishIngredientEntity;
import development.v.development.infrastruture.mappers.DishIngredientMapper;

@Repository
public class DishIngredientRepositoryImpl implements DishIngredientRepository {

    private final DishIngredientJpaRepository jpaRepository;

    public DishIngredientRepositoryImpl(DishIngredientJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public DishIngredient save(DishIngredient dishIngredient) {
        DishIngredientEntity entity = DishIngredientMapper.toEntity(dishIngredient);
        return DishIngredientMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<DishIngredient> findById(Long id) {
        return jpaRepository.findById(id)
            .map(DishIngredientMapper::toDomain);
    }

    @Override
    public PaginatedResultDto<List<DishIngredient>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<DishIngredientEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<DishIngredientEntity> result = jpaRepository.findAll(spec, pageable);

        List<DishIngredient> data = result.getContent()
                .stream()
                .map(DishIngredientMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public DishIngredient update(DishIngredient dishIngredient) {
        DishIngredientEntity entity = DishIngredientMapper.toEntity(dishIngredient);
        return DishIngredientMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
