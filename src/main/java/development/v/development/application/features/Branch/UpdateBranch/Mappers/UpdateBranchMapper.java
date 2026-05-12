package development.v.development.application.features.Branch.UpdateBranch.Mappers;

import development.v.development.application.features.Branch.UpdateBranch.Dtos.UpdateBranchRequest;
import development.v.development.domain.models.Branch;

public class UpdateBranchMapper {

    public static Branch toDomain(Long id, UpdateBranchRequest request) {
        Branch branch = new Branch();
        branch.setSedeId(id);
        branch.setSedeNombre(request.getSedeNombre());
        branch.setSedeDireccion(request.getSedeDireccion());
        branch.setSedeTelefono(request.getSedeTelefono());
        branch.setSedeEstado(request.getSedeEstado());
        return branch;
    }
}
