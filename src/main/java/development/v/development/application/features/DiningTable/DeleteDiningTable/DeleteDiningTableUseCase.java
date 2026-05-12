package development.v.development.application.features.DiningTable.DeleteDiningTable;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.DiningTable;
import development.v.development.domain.repositories.DiningTableRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeleteDiningTableUseCase {

    private final DiningTableRepository repository;

    public DeleteDiningTableUseCase(DiningTableRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<DiningTable> execute(Long id) {
        DiningTable diningTable = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
        repository.delete(id);
        return DataResultDto.success(diningTable, Message.SUCCESS);
    }
}
