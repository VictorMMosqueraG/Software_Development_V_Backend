package development.v.development.application.features.DiningTable.UpdateDiningTable;

import org.springframework.stereotype.Service;

import development.v.development.application.features.DiningTable.UpdateDiningTable.Dtos.UpdateDiningTableRequest;
import development.v.development.application.features.DiningTable.UpdateDiningTable.Mappers.UpdateDiningTableMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.DiningTable;
import development.v.development.domain.repositories.DiningTableRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateDiningTableUseCase {

    private final DiningTableRepository repository;

    public UpdateDiningTableUseCase(DiningTableRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<DiningTable> execute(Long id, UpdateDiningTableRequest request) {
        repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        DiningTable domain = UpdateDiningTableMapper.toDomain(id, request);
        DiningTable updated = repository.update(domain);
        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
