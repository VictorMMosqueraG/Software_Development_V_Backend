package development.v.development.application.features.Branch.GetBranchById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Branch;
import development.v.development.domain.repositories.BranchRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetBranchByIdUseCase {
    private final BranchRepository branchRepository;

    public GetBranchByIdUseCase(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public DataResultDto<Branch> execute(Long id) {
        Branch branch = branchRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        return DataResultDto.success(
                branch,
                Message.SUCCESS);
    }
}
