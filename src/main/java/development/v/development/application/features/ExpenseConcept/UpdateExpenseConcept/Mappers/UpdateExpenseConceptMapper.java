package development.v.development.application.features.ExpenseConcept.UpdateExpenseConcept.Mappers;

import development.v.development.application.features.ExpenseConcept.UpdateExpenseConcept.Dtos.UpdateExpenseConceptRequest;
import development.v.development.domain.models.ExpenseConcept;

public class UpdateExpenseConceptMapper {
    public static ExpenseConcept toDomain(Long id, UpdateExpenseConceptRequest request) {
        ExpenseConcept model = new ExpenseConcept();
        model.setConId(id);
        model.setConDescripcion(request.getConDescripcion());
        model.setConEstado(request.getConEstado());
        return model;
    }
}
