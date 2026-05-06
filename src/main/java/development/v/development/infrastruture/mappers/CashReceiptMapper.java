package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.CashReceipt;
import development.v.development.infrastruture.entities.CashReceiptEntity;
import development.v.development.infrastruture.enums.CashReceiptStatus;

public class CashReceiptMapper {

    public static CashReceipt toDomain(CashReceiptEntity entity) {
        CashReceipt model = new CashReceipt();
        model.setRcNum(entity.getRcNum());
        model.setSedeId(entity.getSedeId());
        model.setUsuId(entity.getUsuId());
        model.setRcFecha(entity.getRcFecha());
        model.setPedId(entity.getPedId());
        model.setCliId(entity.getCliId());
        model.setFpId(entity.getFpId());
        model.setRcSubtotal(entity.getRcSubtotal());
        model.setRcDescuento(entity.getRcDescuento());
        model.setRcPropina(entity.getRcPropina());
        model.setRcTotal(entity.getRcTotal());
        model.setRcMontoRec(entity.getRcMontoRec());
        model.setRcCambio(entity.getRcCambio());
        model.setRcObservacion(entity.getRcObservacion());
        model.setRcEstado(entity.getRcEstado().name());
        model.setCreatedAt(entity.getCreatedAt());
        model.setUpdatedAt(entity.getUpdatedAt());
        return model;
    }

    public static CashReceiptEntity toEntity(CashReceipt model) {
        CashReceiptEntity entity = new CashReceiptEntity();
        entity.setRcNum(model.getRcNum());
        entity.setSedeId(model.getSedeId());
        entity.setUsuId(model.getUsuId());
        entity.setRcFecha(model.getRcFecha());
        entity.setPedId(model.getPedId());
        entity.setCliId(model.getCliId());
        entity.setFpId(model.getFpId());
        entity.setRcSubtotal(model.getRcSubtotal());
        entity.setRcDescuento(model.getRcDescuento());
        entity.setRcPropina(model.getRcPropina());
        entity.setRcTotal(model.getRcTotal());
        entity.setRcMontoRec(model.getRcMontoRec());
        entity.setRcCambio(model.getRcCambio());
        entity.setRcObservacion(model.getRcObservacion());
        entity.setRcEstado(CashReceiptStatus.valueOf(model.getRcEstado()));
        return entity;
    }
}
