package development.v.development.application.features.ExpenseConcept.GetAllExpenseConcept.Mappers;

import development.v.development.application.features.ExpenseConcept.GetAllExpenseConcept.Dtos.GetAllExpenseConceptQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllExpenseConceptMapper {
    public static EntityFilter toFilter(GetAllExpenseConceptQuery query) {
        return new EntityFilter(query)
                .addFilter("conEstado", query.getConEstado());
    }
}
