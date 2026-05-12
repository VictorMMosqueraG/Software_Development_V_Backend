package development.v.development.application.features.Presentation.UpdatePresentation.Mappers;

import development.v.development.application.features.Presentation.UpdatePresentation.Dtos.UpdatePresentationRequest;
import development.v.development.domain.models.Presentation;

public class UpdatePresentationMapper {

    public static Presentation toDomain(Long id, UpdatePresentationRequest request) {
        Presentation presentation = new Presentation();
        presentation.setPresId(id);
        presentation.setPresDescripcion(request.getPresDescripcion());
        presentation.setPresAbreviatura(request.getPresAbreviatura());
        presentation.setPresEstado(request.getPresEstado());
        return presentation;
    }
}
