package development.v.development.application.features.CashReceipt.CreateCashReceipt.Mappers;

import development.v.development.application.features.CashReceipt.CreateCashReceipt.Dtos.CreateCashReceiptRequest;
import development.v.development.domain.models.CashReceipt;

public class CreateCashReceiptMapper {

    public static CashReceipt RequestToDomain(CreateCashReceiptRequest request) {
        CashReceipt model = new CashReceipt();
        model.setSedeId(request.getSedeId());
        model.setUsuId(request.getUsuId());
        model.setRcFecha(request.getRcFecha());
        model.setPedId(request.getPedId());
        model.setCliId(request.getCliId());
        model.setFpId(request.getFpId());
        model.setRcSubtotal(request.getRcSubtotal());
        model.setRcDescuento(request.getRcDescuento());
        model.setRcPropina(request.getRcPropina());
        model.setRcTotal(request.getRcTotal());
        model.setRcMontoRec(request.getRcMontoRec());
        model.setRcCambio(request.getRcCambio());
        model.setRcObservacion(request.getRcObservacion());
        model.setRcEstado(request.getRcEstado());
        return model;
    }
}
