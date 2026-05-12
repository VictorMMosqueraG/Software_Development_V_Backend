package development.v.development.application.features.Branch.UpdateBranch;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Branch.UpdateBranch.Dtos.UpdateBranchRequest;
import development.v.development.application.features.Branch.UpdateBranch.Mappers.UpdateBranchMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Branch;
import development.v.development.domain.repositories.BranchRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateBranchUseCase {
    private final BranchRepository branchRepository;

    public UpdateBranchUseCase(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public DataResultDto<Branch> execute(Long id, UpdateBranchRequest request) {

        branchRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        Branch domain = UpdateBranchMapper.toDomain(id, request);
        Branch updatedBranch = branchRepository.update(domain);

        return DataResultDto.success(
                updatedBranch,
                Message.SUCCESS);
    }
}
