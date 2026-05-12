package development.v.development.application.features.Branch.CreateBranch;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Branch.CreateBranch.Dtos.CreateBranchRequestDto;
import development.v.development.application.features.Branch.CreateBranch.Mappers.CreateBranchMapper;
import development.v.development.domain.exceptions.ConflictException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Branch;
import development.v.development.domain.repositories.BranchRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateBranchUseCase {

    private final BranchRepository branchRepository;

    public CreateBranchUseCase(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public DataResultDto<Branch> execute(CreateBranchRequestDto request) {

        if (branchRepository.existsBySedeNombre(request.getSedeNombre())) {
            throw new ConflictException(Message.ALREADY_EXIST + " Nombre de la sede");
        }

        Branch domain = CreateBranchMapper.toDomain(request);
        branchRepository.save(domain);

        return DataResultDto.success(domain, Message.SUCCESS);
    }
}
