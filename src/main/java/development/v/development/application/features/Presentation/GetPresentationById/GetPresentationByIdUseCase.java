package development.v.development.application.features.Presentation.GetPresentationById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Presentation;
import development.v.development.domain.repositories.PresentationRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetPresentationByIdUseCase {
    private final PresentationRepository presentationRepository;

    public GetPresentationByIdUseCase(PresentationRepository presentationRepository) {
        this.presentationRepository = presentationRepository;
    }

    public DataResultDto<Presentation> execute(Long id) {
        Presentation presentation = presentationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        return DataResultDto.success(presentation, Message.SUCCESS);
    }
}
