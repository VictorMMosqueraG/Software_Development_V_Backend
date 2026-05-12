package development.v.development.application.features.Branch.GetAllBranch.Mappers;

import development.v.development.application.features.Branch.GetAllBranch.Dtos.GetAllBranchQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllBranchMapper {

    public static EntityFilter toFilter(GetAllBranchQuery query) {
        return new EntityFilter(query)
                .addFilter("sedeEstado", query.getSedeEstado());
    }
}
