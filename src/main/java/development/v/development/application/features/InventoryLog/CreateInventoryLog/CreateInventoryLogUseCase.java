package development.v.development.application.features.InventoryLog.CreateInventoryLog;

import org.springframework.stereotype.Service;

import development.v.development.application.features.InventoryLog.CreateInventoryLog.Dtos.CreateInventoryLogRequestDto;
import development.v.development.application.features.InventoryLog.CreateInventoryLog.Mappers.CreateInventoryLogMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.InventoryLog;
import development.v.development.domain.repositories.InventoryLogRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateInventoryLogUseCase {

    private final InventoryLogRepository inventoryLogRepository;

    public CreateInventoryLogUseCase(InventoryLogRepository inventoryLogRepository) {
        this.inventoryLogRepository = inventoryLogRepository;
    }

    public DataResultDto<InventoryLog> execute(CreateInventoryLogRequestDto request) {
        InventoryLog domain = CreateInventoryLogMapper.toDomain(request);
        inventoryLogRepository.save(domain);
        return DataResultDto.success(domain, Message.SUCCESS);
    }
}
