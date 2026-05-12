package development.v.development.application.features.Supply.DeleteSupply;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Supply;
import development.v.development.domain.repositories.SupplyRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeleteSupplyUseCase {

    private final SupplyRepository supplyRepository;

    public DeleteSupplyUseCase(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    public DataResultDto<Supply> execute(Long id) {
        Supply supply = supplyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        supplyRepository.delete(id);
        return DataResultDto.success(supply, Message.SUCCESS);
    }
}
