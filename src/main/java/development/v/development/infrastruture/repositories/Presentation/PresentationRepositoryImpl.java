package development.v.development.infrastruture.repositories.Presentation;

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
import development.v.development.domain.models.Presentation;
import development.v.development.domain.repositories.PresentationRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.PresentationEntity;
import development.v.development.infrastruture.mappers.PresentationMapper;

@Repository
public class PresentationRepositoryImpl implements PresentationRepository {

    private final PresentationJpaRepository jpaRepository;

    public PresentationRepositoryImpl(PresentationJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Presentation save(Presentation presentation) {
        PresentationEntity entity = PresentationMapper.toEntity(presentation);
        return PresentationMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Presentation> findById(Long id) {
        return jpaRepository.findById(id)
            .map(PresentationMapper::toDomain);
    }

    @Override
    public PaginatedResultDto<List<Presentation>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<PresentationEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<PresentationEntity> result = jpaRepository.findAll(spec, pageable);

        List<Presentation> data = result.getContent()
                .stream()
                .map(PresentationMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public Presentation update(Presentation presentation) {
        PresentationEntity entity = PresentationMapper.toEntity(presentation);
        return PresentationMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
