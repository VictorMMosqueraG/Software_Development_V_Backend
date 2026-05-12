package development.v.development.application.features.SupplyCategory.CreateSupplyCategory;

import org.springframework.stereotype.Service;

import development.v.development.application.features.SupplyCategory.CreateSupplyCategory.Dtos.CreateSupplyCategoryRequestDto;
import development.v.development.application.features.SupplyCategory.CreateSupplyCategory.Mappers.CreateSupplyCategoryMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.SupplyCategory;
import development.v.development.domain.repositories.SupplyCategoryRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateSupplyCategoryUseCase {

    private final SupplyCategoryRepository supplyCategoryRepository;

    public CreateSupplyCategoryUseCase(SupplyCategoryRepository supplyCategoryRepository) {
        this.supplyCategoryRepository = supplyCategoryRepository;
    }

    public DataResultDto<SupplyCategory> execute(CreateSupplyCategoryRequestDto request) {
        SupplyCategory domain = CreateSupplyCategoryMapper.toDomain(request);
        supplyCategoryRepository.save(domain);
        return DataResultDto.success(domain, Message.SUCCESS);
    }
}
