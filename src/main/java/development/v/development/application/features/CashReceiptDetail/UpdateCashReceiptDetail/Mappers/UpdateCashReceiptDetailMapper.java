package development.v.development.application.features.CashReceiptDetail.UpdateCashReceiptDetail.Mappers;

import development.v.development.application.features.CashReceiptDetail.UpdateCashReceiptDetail.Dtos.UpdateCashReceiptDetailRequest;
import development.v.development.domain.models.CashReceiptDetail;

public class UpdateCashReceiptDetailMapper {

    private UpdateCashReceiptDetailMapper() {}

    public static CashReceiptDetail toDomain(Long id, UpdateCashReceiptDetailRequest request) {
        CashReceiptDetail detail = new CashReceiptDetail();
        detail.setRcdId(id);
        detail.setRcNum(request.getRcNum());
        detail.setPlaId(request.getPlaId());
        detail.setRcdCantidad(request.getRcdCantidad());
        detail.setRcdPrecio(request.getRcdPrecio());
        detail.setRcdDescuento(request.getRcdDescuento());
        return detail;
    }
}
