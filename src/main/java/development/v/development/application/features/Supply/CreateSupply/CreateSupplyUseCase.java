package development.v.development.application.features.Supply.CreateSupply;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Supply.CreateSupply.Dtos.CreateSupplyRequestDto;
import development.v.development.application.features.Supply.CreateSupply.Mappers.CreateSupplyMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Supply;
import development.v.development.domain.repositories.SupplyRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateSupplyUseCase {

    private final SupplyRepository supplyRepository;

    public CreateSupplyUseCase(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    public DataResultDto<Supply> execute(CreateSupplyRequestDto request) {
        Supply domain = CreateSupplyMapper.toDomain(request);
        supplyRepository.save(domain);
        return DataResultDto.success(domain, Message.SUCCESS);
    }
}
