package development.v.development.application.features.ExpenseHeader.GetAllExpenseHeader.Mappers;

import development.v.development.application.features.ExpenseHeader.GetAllExpenseHeader.Dtos.GetAllExpenseHeaderQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllExpenseHeaderMapper {
    public static EntityFilter toFilter(GetAllExpenseHeaderQuery query) {
        return new EntityFilter(query)
                .addFilter("egrEstado", query.getEgrEstado())
                .addFilter("sedeId", query.getSedeId());
    }
}
