package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.Reservation;
import development.v.development.infrastruture.entities.ReservationEntity;

public class ReservationMapper {

    public static Reservation toDomain(ReservationEntity entity) {
        Reservation model = new Reservation();
        model.setResId(entity.getResId());
        model.setSedeId(entity.getSedeId());
        model.setResNombreCli(entity.getResNombreCli());
        model.setResTelefono(entity.getResTelefono());
        model.setResFechaHora(entity.getResFechaHora());
        model.setResPersonas(entity.getResPersonas());
        model.setMesaId(entity.getMesaId());
        model.setResNota(entity.getResNota());
        model.setResEstado(entity.getResEstado());
        model.setCreatedAt(entity.getCreatedAt());
        model.setUpdatedAt(entity.getUpdatedAt());
        return model;
    }

    public static ReservationEntity toEntity(Reservation model) {
        ReservationEntity entity = new ReservationEntity();
        entity.setResId(model.getResId());
        entity.setSedeId(model.getSedeId());
        entity.setResNombreCli(model.getResNombreCli());
        entity.setResTelefono(model.getResTelefono());
        entity.setResFechaHora(model.getResFechaHora());
        entity.setResPersonas(model.getResPersonas());
        entity.setMesaId(model.getMesaId());
        entity.setResNota(model.getResNota());
        entity.setResEstado(model.getResEstado());
        return entity;
    }
}
