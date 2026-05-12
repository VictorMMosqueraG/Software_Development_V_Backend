package development.v.development.application.features.ExpenseHeader.CreateExpenseHeader.Mappers;

import development.v.development.application.features.ExpenseHeader.CreateExpenseHeader.Dtos.CreateExpenseHeaderRequestDto;
import development.v.development.domain.models.ExpenseHeader;

public class CreateExpenseHeaderMapper {
    public static ExpenseHeader toDomain(CreateExpenseHeaderRequestDto request) {
        ExpenseHeader model = new ExpenseHeader();
        model.setSedeId(request.getSedeId());
        model.setNoEgreso(request.getNoEgreso());
        model.setFechaDocumento(request.getFechaDocumento());
        model.setTerceroIdentificacion(request.getTerceroIdentificacion());
        model.setTerceroNombre(request.getTerceroNombre());
        model.setDetalle(request.getDetalle());
        model.setFpId(request.getFpId());
        model.setConId(request.getConId());
        model.setNoDocumento(request.getNoDocumento());
        model.setValorEgreso(request.getValorEgreso());
        model.setUsuId(request.getUsuId());
        model.setEgrEstado(request.getEgrEstado());
        return model;
    }
}
