package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.ExpenseConcept;
import development.v.development.infrastruture.entities.ExpenseConceptEntity;
import development.v.development.infrastruture.enums.ExpenseConceptStatus;

public class ExpenseConceptMapper {
    public static ExpenseConcept toDomain(ExpenseConceptEntity entity) {
        ExpenseConcept model = new ExpenseConcept();
        model.setConId(entity.getConId());
        model.setConDescripcion(entity.getConDescripcion());
        model.setConEstado(entity.getConEstado() != null ? entity.getConEstado().name() : null);
        model.setCreatedAt(entity.getCreatedAt());
        model.setUpdatedAt(entity.getUpdatedAt());
        return model;
    }

    public static ExpenseConceptEntity toEntity(ExpenseConcept model) {
        ExpenseConceptEntity entity = new ExpenseConceptEntity();
        entity.setConId(model.getConId());
        entity.setConDescripcion(model.getConDescripcion());
        if (model.getConEstado() != null) {
            entity.setConEstado(ExpenseConceptStatus.valueOf(model.getConEstado()));
        }
        return entity;
    }
}
