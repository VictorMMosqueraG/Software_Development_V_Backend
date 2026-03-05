package development.v.development.application.cases.CashReceipt.CreateCashReceipt.Mappers;

import development.v.development.application.cases.CashReceipt.CreateCashReceipt.Dtos.CreateCashReceiptRequest;
import development.v.development.domain.models.CashReceipt;

public class CreateCashReceiptMapper {

    public static CashReceipt RequestToDomain(CreateCashReceiptRequest request) {
        CashReceipt model = new CashReceipt();
        model.setUsuId(request.getUsuId());
        model.setRcFecha(request.getRcFecha());
        model.setPedId(request.getPedId());
        model.setCliId(request.getCliId());
        model.setRcTotal(request.getRcTotal());
        model.setRcObservacion(request.getRcObservacion());
        model.setRcEstado(request.getRcEstado());
        return model;
    }

}
