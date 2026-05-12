package development.v.development.application.features.DiningTable.CreateDiningTable;

import org.springframework.stereotype.Service;

import development.v.development.application.features.DiningTable.CreateDiningTable.Dtos.CreateDiningTableRequestDto;
import development.v.development.application.features.DiningTable.CreateDiningTable.Mappers.CreateDiningTableMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.DiningTable;
import development.v.development.domain.repositories.DiningTableRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateDiningTableUseCase {

    private final DiningTableRepository repository;

    public CreateDiningTableUseCase(DiningTableRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<DiningTable> execute(CreateDiningTableRequestDto request) {
        DiningTable domain = CreateDiningTableMapper.toDomain(request);
        repository.save(domain);
        return DataResultDto.success(domain, Message.SUCCESS);
    }
}
