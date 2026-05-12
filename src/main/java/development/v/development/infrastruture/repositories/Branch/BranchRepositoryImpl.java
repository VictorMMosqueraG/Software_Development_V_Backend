package development.v.development.infrastruture.repositories.Branch;

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
import development.v.development.domain.models.Branch;
import development.v.development.domain.repositories.BranchRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.BranchEntity;
import development.v.development.infrastruture.mappers.BranchMapper;

@Repository
public class BranchRepositoryImpl implements BranchRepository {

    private final BranchJpaRepository jpaRepository;

    public BranchRepositoryImpl(BranchJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Branch save(Branch branch) {
        BranchEntity entity = BranchMapper.toEntity(branch);
        return BranchMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Branch> findById(Long id) {
        return jpaRepository.findById(id)
            .map(BranchMapper::toDomain);
    }

    @Override
    public boolean existsBySedeNombre(String sedeNombre) {
        return jpaRepository.existsBySedeNombre(sedeNombre);
    }

    @Override
    public PaginatedResultDto<List<Branch>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<BranchEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<BranchEntity> result = jpaRepository.findAll(spec, pageable);

        List<Branch> data = result.getContent()
                .stream()
                .map(BranchMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public Branch update(Branch branch) {
        BranchEntity entity = BranchMapper.toEntity(branch);
        return BranchMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
