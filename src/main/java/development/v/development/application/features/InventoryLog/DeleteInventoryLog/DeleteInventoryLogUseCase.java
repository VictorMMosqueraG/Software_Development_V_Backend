package development.v.development.application.features.InventoryLog.DeleteInventoryLog;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.InventoryLog;
import development.v.development.domain.repositories.InventoryLogRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeleteInventoryLogUseCase {

    private final InventoryLogRepository inventoryLogRepository;

    public DeleteInventoryLogUseCase(InventoryLogRepository inventoryLogRepository) {
        this.inventoryLogRepository = inventoryLogRepository;
    }

    public DataResultDto<InventoryLog> execute(Long id) {
        InventoryLog inventoryLog = inventoryLogRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        inventoryLogRepository.delete(id);
        return DataResultDto.success(inventoryLog, Message.SUCCESS);
    }
}
