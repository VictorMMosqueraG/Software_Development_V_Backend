package development.v.development.application.features.SupplyCategory.GetSupplyCategoryById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.SupplyCategory;
import development.v.development.domain.repositories.SupplyCategoryRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetSupplyCategoryByIdUseCase {
    private final SupplyCategoryRepository supplyCategoryRepository;

    public GetSupplyCategoryByIdUseCase(SupplyCategoryRepository supplyCategoryRepository) {
        this.supplyCategoryRepository = supplyCategoryRepository;
    }

    public DataResultDto<SupplyCategory> execute(Long id) {
        SupplyCategory supplyCategory = supplyCategoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        return DataResultDto.success(supplyCategory, Message.SUCCESS);
    }
}
