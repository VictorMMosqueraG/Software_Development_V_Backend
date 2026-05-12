package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.ExpenseHeader;
import development.v.development.infrastruture.entities.ExpenseHeaderEntity;
import development.v.development.infrastruture.enums.ExpenseHeaderStatus;

public class ExpenseHeaderMapper {
    public static ExpenseHeader toDomain(ExpenseHeaderEntity entity) {
        ExpenseHeader model = new ExpenseHeader();
        model.setEgrId(entity.getEgrId());
        model.setSedeId(entity.getSedeId());
        model.setNoEgreso(entity.getNoEgreso());
        model.setFechaDocumento(entity.getFechaDocumento());
        model.setTerceroIdentificacion(entity.getTerceroIdentificacion());
        model.setTerceroNombre(entity.getTerceroNombre());
        model.setDetalle(entity.getDetalle());
        model.setFpId(entity.getFpId());
        model.setConId(entity.getConId());
        model.setNoDocumento(entity.getNoDocumento());
        model.setValorEgreso(entity.getValorEgreso());
        model.setUsuId(entity.getUsuId());
        model.setEgrEstado(entity.getEgrEstado() != null ? entity.getEgrEstado().name() : null);
        model.setCreatedAt(entity.getCreatedAt());
        model.setUpdatedAt(entity.getUpdatedAt());
        return model;
    }

    public static ExpenseHeaderEntity toEntity(ExpenseHeader model) {
        ExpenseHeaderEntity entity = new ExpenseHeaderEntity();
        entity.setEgrId(model.getEgrId());
        entity.setSedeId(model.getSedeId());
        entity.setNoEgreso(model.getNoEgreso());
        entity.setFechaDocumento(model.getFechaDocumento());
        entity.setTerceroIdentificacion(model.getTerceroIdentificacion());
        entity.setTerceroNombre(model.getTerceroNombre());
        entity.setDetalle(model.getDetalle());
        entity.setFpId(model.getFpId());
        entity.setConId(model.getConId());
        entity.setNoDocumento(model.getNoDocumento());
        entity.setValorEgreso(model.getValorEgreso());
        entity.setUsuId(model.getUsuId());
        if (model.getEgrEstado() != null) {
            entity.setEgrEstado(ExpenseHeaderStatus.valueOf(model.getEgrEstado()));
        }
        return entity;
    }
}
