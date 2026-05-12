package development.v.development.application.features.InventoryLog.GetAllInventoryLog;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.InventoryLog.GetAllInventoryLog.Dtos.GetAllInventoryLogQuery;
import development.v.development.application.features.InventoryLog.GetAllInventoryLog.Mappers.GetAllInventoryLogMapper;
import development.v.development.domain.models.InventoryLog;
import development.v.development.domain.repositories.InventoryLogRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllInventoryLogUseCase {

    private final InventoryLogRepository repository;

    public GetAllInventoryLogUseCase(InventoryLogRepository inventoryLogRepository) {
        this.repository = inventoryLogRepository;
    }

    public PaginatedResultDto<List<InventoryLog>> execute(GetAllInventoryLogQuery query) {
        return repository.findAllPaginated(GetAllInventoryLogMapper.toFilter(query));
    }
}
