package development.v.development.application.features.DiningArea.DeleteDiningArea;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.DiningArea;
import development.v.development.domain.repositories.DiningAreaRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeleteDiningAreaUseCase {

    private final DiningAreaRepository repository;

    public DeleteDiningAreaUseCase(DiningAreaRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<DiningArea> execute(Long id) {
        DiningArea diningArea = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
        repository.delete(id);
        return DataResultDto.success(diningArea, Message.SUCCESS);
    }
}
