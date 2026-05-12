package development.v.development.infrastruture.repositories.ExpenseHeader;

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
import development.v.development.domain.models.ExpenseHeader;
import development.v.development.domain.repositories.ExpenseHeaderRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.ExpenseHeaderEntity;
import development.v.development.infrastruture.mappers.ExpenseHeaderMapper;

@Repository
public class ExpenseHeaderRepositoryImpl implements ExpenseHeaderRepository {

    private final ExpenseHeaderJpaRepository jpaRepository;

    public ExpenseHeaderRepositoryImpl(ExpenseHeaderJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ExpenseHeader save(ExpenseHeader expenseHeader) {
        ExpenseHeaderEntity entity = ExpenseHeaderMapper.toEntity(expenseHeader);
        return ExpenseHeaderMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<ExpenseHeader> findById(Long id) {
        return jpaRepository.findById(id).map(ExpenseHeaderMapper::toDomain);
    }

    @Override
    public boolean existsByNoEgreso(Long noEgreso) {
        return jpaRepository.existsByNoEgreso(noEgreso);
    }

    @Override
    public PaginatedResultDto<List<ExpenseHeader>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<ExpenseHeaderEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<ExpenseHeaderEntity> result = jpaRepository.findAll(spec, pageable);

        List<ExpenseHeader> data = result.getContent()
                .stream()
                .map(ExpenseHeaderMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public ExpenseHeader update(ExpenseHeader expenseHeader) {
        ExpenseHeaderEntity entity = ExpenseHeaderMapper.toEntity(expenseHeader);
        return ExpenseHeaderMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
