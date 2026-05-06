package development.v.development.application.features.CashReceiptDetail.CreateCashReceiptDetail.Mappers;

import development.v.development.application.features.CashReceiptDetail.CreateCashReceiptDetail.Dtos.CreateCashReceiptDetailRequest;
import development.v.development.domain.models.CashReceiptDetail;

public class CreateCashReceiptDetailMapper {

    public static CashReceiptDetail RequestToDomain(CreateCashReceiptDetailRequest request) {
        CashReceiptDetail model = new CashReceiptDetail();
        model.setRcNum(request.getRcNum());
        model.setPlaId(request.getPlaId());
        model.setRcdCantidad(request.getRcdCantidad());
        model.setRcdPrecio(request.getRcdPrecio());
        model.setRcdDescuento(request.getRcdDescuento());
        return model;
    }
}
