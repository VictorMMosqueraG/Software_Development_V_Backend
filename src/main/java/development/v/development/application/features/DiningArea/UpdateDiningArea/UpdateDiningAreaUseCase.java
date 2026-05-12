package development.v.development.application.features.DiningArea.UpdateDiningArea;

import org.springframework.stereotype.Service;

import development.v.development.application.features.DiningArea.UpdateDiningArea.Dtos.UpdateDiningAreaRequest;
import development.v.development.application.features.DiningArea.UpdateDiningArea.Mappers.UpdateDiningAreaMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.DiningArea;
import development.v.development.domain.repositories.DiningAreaRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateDiningAreaUseCase {

    private final DiningAreaRepository repository;

    public UpdateDiningAreaUseCase(DiningAreaRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<DiningArea> execute(Long id, UpdateDiningAreaRequest request) {
        repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        DiningArea domain = UpdateDiningAreaMapper.toDomain(id, request);
        DiningArea updated = repository.update(domain);
        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
