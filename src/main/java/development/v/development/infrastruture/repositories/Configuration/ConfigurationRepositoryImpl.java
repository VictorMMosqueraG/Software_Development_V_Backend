package development.v.development.infrastruture.repositories.Configuration;

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
import development.v.development.domain.models.Configuration;
import development.v.development.domain.repositories.ConfigurationRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import development.v.development.infrastruture.entities.ConfigurationEntity;
import development.v.development.infrastruture.mappers.ConfigurationMapper;

@Repository
public class ConfigurationRepositoryImpl implements ConfigurationRepository {

    private final ConfigurationJpaRepository jpaRepository;

    public ConfigurationRepositoryImpl(ConfigurationJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Configuration save(Configuration configuration) {
        ConfigurationEntity entity = ConfigurationMapper.toEntity(configuration);
        return ConfigurationMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<Configuration> findById(Long id) {
        return jpaRepository.findById(id).map(ConfigurationMapper::toDomain);
    }

    @Override
    public boolean existsByCfgClave(String cfgClave) {
        return jpaRepository.existsByCfgClave(cfgClave);
    }

    @Override
    public PaginatedResultDto<List<Configuration>> findAllPaginated(EntityFilter filter) {
        PaginationDto pagination = filter.getPagination();

        Sort.Direction direction = pagination.getOrder().equalsIgnoreCase("desc")
                ? Sort.Direction.DESC : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(
                pagination.getPage() - 1,
                pagination.getPageSize(),
                Sort.by(direction, pagination.getSort()));

        Specification<ConfigurationEntity> spec = (root, query, cb) -> cb.conjunction();

        for (Map.Entry<String, Object> entry : filter.getFilters().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            spec = spec.and((root, query, cb) -> cb.equal(root.get(key), value));
        }

        Page<ConfigurationEntity> result = jpaRepository.findAll(spec, pageable);

        List<Configuration> data = result.getContent()
                .stream()
                .map(ConfigurationMapper::toDomain)
                .collect(Collectors.toList());

        return PaginatedResultDto.success(
                (int) result.getTotalElements(),
                pagination.getPage(),
                pagination.getPageSize(),
                data,
                Message.SUCCESS);
    }

    @Override
    public Configuration update(Configuration configuration) {
        ConfigurationEntity entity = ConfigurationMapper.toEntity(configuration);
        return ConfigurationMapper.toDomain(jpaRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
