package development.v.development.application.features.SupplyCategory.UpdateSupplyCategory;

import org.springframework.stereotype.Service;

import development.v.development.application.features.SupplyCategory.UpdateSupplyCategory.Dtos.UpdateSupplyCategoryRequest;
import development.v.development.application.features.SupplyCategory.UpdateSupplyCategory.Mappers.UpdateSupplyCategoryMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.SupplyCategory;
import development.v.development.domain.repositories.SupplyCategoryRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateSupplyCategoryUseCase {
    private final SupplyCategoryRepository supplyCategoryRepository;

    public UpdateSupplyCategoryUseCase(SupplyCategoryRepository supplyCategoryRepository) {
        this.supplyCategoryRepository = supplyCategoryRepository;
    }

    public DataResultDto<SupplyCategory> execute(Long id, UpdateSupplyCategoryRequest request) {
        supplyCategoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        SupplyCategory domain = UpdateSupplyCategoryMapper.toDomain(id, request);
        SupplyCategory updated = supplyCategoryRepository.update(domain);

        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
