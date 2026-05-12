package development.v.development.application.features.ExpenseHeader.UpdateExpenseHeader.Mappers;

import development.v.development.application.features.ExpenseHeader.UpdateExpenseHeader.Dtos.UpdateExpenseHeaderRequest;
import development.v.development.domain.models.ExpenseHeader;

public class UpdateExpenseHeaderMapper {
    public static ExpenseHeader toDomain(Long id, UpdateExpenseHeaderRequest request) {
        ExpenseHeader model = new ExpenseHeader();
        model.setEgrId(id);
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
