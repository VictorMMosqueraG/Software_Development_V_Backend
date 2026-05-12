package development.v.development.infrastruture.repositories.ExpenseConcept;

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
import development.v.development.domain.models.ExpenseConcept;
import development.v.development.domain.repositories.ExpenseConceptRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.ExpenseConceptEntity;
import development.v.development.infrastruture.mappers.ExpenseConceptMapper;

@Repository
public class ExpenseConceptRepositoryImpl implements ExpenseConceptRepository {

    private final ExpenseConceptJpaRepository jpaRepository;

    public ExpenseConceptRepositoryImpl(ExpenseConceptJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ExpenseConcept save(ExpenseConcept expenseConcept) {
        ExpenseConceptEntity entity = ExpenseConceptMapper.toEntity(expenseConcept);
        return ExpenseConceptMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<ExpenseConcept> findById(Long id) {
        return jpaRepository.findById(id).map(ExpenseConceptMapper::toDomain);
    }

    @Override
    public PaginatedResultDto<List<ExpenseConcept>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<ExpenseConceptEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<ExpenseConceptEntity> result = jpaRepository.findAll(spec, pageable);

        List<ExpenseConcept> data = result.getContent()
                .stream()
                .map(ExpenseConceptMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public ExpenseConcept update(ExpenseConcept expenseConcept) {
        ExpenseConceptEntity entity = ExpenseConceptMapper.toEntity(expenseConcept);
        return ExpenseConceptMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
