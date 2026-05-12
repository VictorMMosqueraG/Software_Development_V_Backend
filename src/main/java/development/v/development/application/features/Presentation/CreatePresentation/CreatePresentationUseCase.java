package development.v.development.application.features.Presentation.CreatePresentation;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Presentation.CreatePresentation.Dtos.CreatePresentationRequestDto;
import development.v.development.application.features.Presentation.CreatePresentation.Mappers.CreatePresentationMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Presentation;
import development.v.development.domain.repositories.PresentationRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreatePresentationUseCase {

    private final PresentationRepository presentationRepository;

    public CreatePresentationUseCase(PresentationRepository presentationRepository) {
        this.presentationRepository = presentationRepository;
    }

    public DataResultDto<Presentation> execute(CreatePresentationRequestDto request) {
        Presentation domain = CreatePresentationMapper.toDomain(request);
        presentationRepository.save(domain);
        return DataResultDto.success(domain, Message.SUCCESS);
    }
}
