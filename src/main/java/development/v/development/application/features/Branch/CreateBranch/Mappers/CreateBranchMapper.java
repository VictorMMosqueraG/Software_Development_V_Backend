package development.v.development.application.features.Branch.CreateBranch.Mappers;

import development.v.development.application.features.Branch.CreateBranch.Dtos.CreateBranchRequestDto;
import development.v.development.domain.models.Branch;

public class CreateBranchMapper {

    public static Branch toDomain(CreateBranchRequestDto request) {
        Branch branch = new Branch();
        branch.setSedeNombre(request.getSedeNombre());
        branch.setSedeDireccion(request.getSedeDireccion());
        branch.setSedeTelefono(request.getSedeTelefono());
        branch.setSedeEstado(request.getSedeEstado());
        return branch;
    }
}
