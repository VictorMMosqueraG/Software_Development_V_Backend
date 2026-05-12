package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.Branch;
import development.v.development.infrastruture.entities.BranchEntity;
import development.v.development.infrastruture.enums.BranchStatus;

public class BranchMapper {
    public static Branch toDomain(BranchEntity entity) {
        Branch branch = new Branch();
        branch.setSedeId(entity.getSedeId());
        branch.setSedeNombre(entity.getSedeNombre());
        branch.setSedeDireccion(entity.getSedeDireccion());
        branch.setSedeTelefono(entity.getSedeTelefono());
        branch.setSedeEstado(entity.getSedeEstado() != null
                ? entity.getSedeEstado().name() : null);
        branch.setCreatedAt(entity.getCreatedAt());
        branch.setUpdatedAt(entity.getUpdatedAt());
        return branch;
    }

    public static BranchEntity toEntity(Branch branch) {
        BranchEntity entity = new BranchEntity();
        entity.setSedeId(branch.getSedeId());
        entity.setSedeNombre(branch.getSedeNombre());
        entity.setSedeDireccion(branch.getSedeDireccion());
        entity.setSedeTelefono(branch.getSedeTelefono());
        if (branch.getSedeEstado() != null) {
            entity.setSedeEstado(BranchStatus
                    .valueOf(branch.getSedeEstado()));
        }
        return entity;
    }
}
