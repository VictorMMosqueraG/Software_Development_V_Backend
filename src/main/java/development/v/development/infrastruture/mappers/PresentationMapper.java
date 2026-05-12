package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.Presentation;
import development.v.development.infrastruture.entities.PresentationEntity;
import development.v.development.infrastruture.enums.PresentationStatus;

public class PresentationMapper {
    public static Presentation toDomain(PresentationEntity entity) {
        Presentation presentation = new Presentation();
        presentation.setPresId(entity.getPresId());
        presentation.setPresDescripcion(entity.getPresDescripcion());
        presentation.setPresAbreviatura(entity.getPresAbreviatura());
        presentation.setPresEstado(entity.getPresEstado() != null
                ? entity.getPresEstado().name() : null);
        presentation.setCreatedAt(entity.getCreatedAt());
        presentation.setUpdatedAt(entity.getUpdatedAt());
        return presentation;
    }

    public static PresentationEntity toEntity(Presentation presentation) {
        PresentationEntity entity = new PresentationEntity();
        entity.setPresId(presentation.getPresId());
        entity.setPresDescripcion(presentation.getPresDescripcion());
        entity.setPresAbreviatura(presentation.getPresAbreviatura());
        if (presentation.getPresEstado() != null) {
            entity.setPresEstado(PresentationStatus
                    .valueOf(presentation.getPresEstado()));
        }
        return entity;
    }
}
