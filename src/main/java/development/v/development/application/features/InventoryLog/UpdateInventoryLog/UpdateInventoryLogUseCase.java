package development.v.development.application.features.InventoryLog.UpdateInventoryLog;

import org.springframework.stereotype.Service;

import development.v.development.application.features.InventoryLog.UpdateInventoryLog.Dtos.UpdateInventoryLogRequest;
import development.v.development.application.features.InventoryLog.UpdateInventoryLog.Mappers.UpdateInventoryLogMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.InventoryLog;
import development.v.development.domain.repositories.InventoryLogRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateInventoryLogUseCase {
    private final InventoryLogRepository inventoryLogRepository;

    public UpdateInventoryLogUseCase(InventoryLogRepository inventoryLogRepository) {
        this.inventoryLogRepository = inventoryLogRepository;
    }

    public DataResultDto<InventoryLog> execute(Long id, UpdateInventoryLogRequest request) {
        inventoryLogRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        InventoryLog domain = UpdateInventoryLogMapper.toDomain(id, request);
        InventoryLog updated = inventoryLogRepository.update(domain);

        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
