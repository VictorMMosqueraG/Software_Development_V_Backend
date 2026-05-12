package development.v.development.application.features.Supply.UpdateSupply;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Supply.UpdateSupply.Dtos.UpdateSupplyRequest;
import development.v.development.application.features.Supply.UpdateSupply.Mappers.UpdateSupplyMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Supply;
import development.v.development.domain.repositories.SupplyRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateSupplyUseCase {
    private final SupplyRepository supplyRepository;

    public UpdateSupplyUseCase(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    public DataResultDto<Supply> execute(Long id, UpdateSupplyRequest request) {
        supplyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        Supply domain = UpdateSupplyMapper.toDomain(id, request);
        Supply updated = supplyRepository.update(domain);

        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
