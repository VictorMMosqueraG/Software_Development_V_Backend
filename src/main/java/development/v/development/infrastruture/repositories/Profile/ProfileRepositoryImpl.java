package development.v.development.infrastruture.repositories.Profile;

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
import development.v.development.domain.models.Profile;
import development.v.development.domain.repositories.ProfileRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.ProfileEntity;
import development.v.development.infrastruture.mappers.ProfileMapper;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository {

    private final ProfileJpaRepository jpaRepository;

    public ProfileRepositoryImpl(ProfileJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Profile save(Profile profile) {
        ProfileEntity entity = ProfileMapper.toEntity(profile);
        return ProfileMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Profile> findById(Long id) {
        return jpaRepository.findById(id)
            .map(ProfileMapper::toDomain);
    }

    @Override
    public boolean existsByPerfDescripcion(String perfDescripcion) {
        return jpaRepository.existsByPerfDescripcion(perfDescripcion);
    }

    @Override
    public PaginatedResultDto<List<Profile>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<ProfileEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<ProfileEntity> result = jpaRepository.findAll(spec, pageable);

        List<Profile> data = result.getContent()
                .stream()
                .map(ProfileMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public Profile update(Profile profile) {
        ProfileEntity entity = ProfileMapper.toEntity(profile);
        return ProfileMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
