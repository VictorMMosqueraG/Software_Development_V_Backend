package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.CashReceipt;
import development.v.development.infrastruture.entities.CashReceiptEntity;

public class CashReceiptMapper {

    public static CashReceipt toDomain(CashReceiptEntity entity) {
        CashReceipt model = new CashReceipt();
        model.setRcNum(entity.getRcNum());
        model.setUsuId(entity.getUsuId());
        model.setRcFecha(entity.getRcFecha());
        model.setPedId(entity.getPedId());
        model.setCliId(entity.getCliId());
        model.setRcTotal(entity.getRcTotal());
        model.setRcObservacion(entity.getRcObservacion());
        model.setRcEstado(entity.getRcEstado());
        return model;
    }

    public static CashReceiptEntity toEntity(CashReceipt model) {
        CashReceiptEntity entity = new CashReceiptEntity();
        entity.setRcNum(model.getRcNum());
        entity.setUsuId(model.getUsuId());
        entity.setRcFecha(model.getRcFecha());
        entity.setPedId(model.getPedId());
        entity.setCliId(model.getCliId());
        entity.setRcTotal(model.getRcTotal());
        entity.setRcObservacion(model.getRcObservacion());
        entity.setRcEstado(model.getRcEstado());
        return entity;
    }
}