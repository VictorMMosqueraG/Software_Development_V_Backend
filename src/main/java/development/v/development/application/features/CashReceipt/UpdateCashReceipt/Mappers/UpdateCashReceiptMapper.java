package development.v.development.application.features.CashReceipt.UpdateCashReceipt.Mappers;

import development.v.development.application.features.CashReceipt.UpdateCashReceipt.Dtos.UpdateCashReceiptRequest;
import development.v.development.domain.models.CashReceipt;

public class UpdateCashReceiptMapper {
    
    private UpdateCashReceiptMapper() {}

    public static CashReceipt toDomain(Integer id, UpdateCashReceiptRequest request) {
        CashReceipt cashReceipt = new CashReceipt();
        cashReceipt.setRcNum(id);
        cashReceipt.setUsuId(request.getUsuId());
        cashReceipt.setRcFecha(request.getRcFecha());
        cashReceipt.setPedId(request.getPedId());
        cashReceipt.setCliId(request.getCliId());
        cashReceipt.setRcTotal(request.getRcTotal());
        cashReceipt.setRcObservacion(request.getRcObservacion());
        cashReceipt.setRcEstado(request.getRcEstado());
        return cashReceipt;
    }
}
