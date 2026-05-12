package development.v.development.application.features.Presentation.CreatePresentation.Mappers;

import development.v.development.application.features.Presentation.CreatePresentation.Dtos.CreatePresentationRequestDto;
import development.v.development.domain.models.Presentation;

public class CreatePresentationMapper {

    public static Presentation toDomain(CreatePresentationRequestDto request) {
        Presentation presentation = new Presentation();
        presentation.setPresDescripcion(request.getPresDescripcion());
        presentation.setPresAbreviatura(request.getPresAbreviatura());
        presentation.setPresEstado(request.getPresEstado());
        return presentation;
    }
}
