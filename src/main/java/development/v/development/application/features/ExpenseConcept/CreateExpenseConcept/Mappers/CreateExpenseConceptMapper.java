package development.v.development.application.features.ExpenseConcept.CreateExpenseConcept.Mappers;

import development.v.development.application.features.ExpenseConcept.CreateExpenseConcept.Dtos.CreateExpenseConceptRequestDto;
import development.v.development.domain.models.ExpenseConcept;

public class CreateExpenseConceptMapper {
    public static ExpenseConcept toDomain(CreateExpenseConceptRequestDto request) {
        ExpenseConcept model = new ExpenseConcept();
        model.setConDescripcion(request.getConDescripcion());
        model.setConEstado(request.getConEstado());
        return model;
    }
}
