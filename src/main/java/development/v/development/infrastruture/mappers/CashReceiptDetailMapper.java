package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.CashReceiptDetail;
import development.v.development.infrastruture.entities.CashReceiptDetailEntity;

public class CashReceiptDetailMapper {

    public static CashReceiptDetail toDomain(CashReceiptDetailEntity entity) {
        CashReceiptDetail model = new CashReceiptDetail();
        model.setRcdId(entity.getRcdId());
        model.setRcNum(entity.getRcNum());
        model.setPlaId(entity.getPlaId());
        model.setRcdCantidad(entity.getRcdCantidad());
        model.setRcdPrecio(entity.getRcdPrecio());
        model.setRcdDescuento(entity.getRcdDescuento());
        model.setCreatedAt(entity.getCreatedAt());
        model.setUpdatedAt(entity.getUpdatedAt());
        return model;
    }

    public static CashReceiptDetailEntity toEntity(CashReceiptDetail model) {
        CashReceiptDetailEntity entity = new CashReceiptDetailEntity();
        entity.setRcdId(model.getRcdId());
        entity.setRcNum(model.getRcNum());
        entity.setPlaId(model.getPlaId());
        entity.setRcdCantidad(model.getRcdCantidad());
        entity.setRcdPrecio(model.getRcdPrecio());
        entity.setRcdDescuento(model.getRcdDescuento());
        return entity;
    }
}
