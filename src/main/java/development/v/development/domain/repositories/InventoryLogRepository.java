package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.InventoryLog;
import development.v.development.domain.responses.PaginatedResultDto;

public interface InventoryLogRepository {
    InventoryLog save(InventoryLog inventoryLog);
    Optional<InventoryLog> findById(Long logId);
    PaginatedResultDto<List<InventoryLog>> findAllPaginated(EntityFilter filter);
    InventoryLog update(InventoryLog inventoryLog);
    void delete(Long id);
}
