package development.v.development.application.features.Presentation.DeletePresentation;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Presentation;
import development.v.development.domain.repositories.PresentationRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeletePresentationUseCase {

    private final PresentationRepository presentationRepository;

    public DeletePresentationUseCase(PresentationRepository presentationRepository) {
        this.presentationRepository = presentationRepository;
    }

    public DataResultDto<Presentation> execute(Long id) {
        Presentation presentation = presentationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        presentationRepository.delete(id);
        return DataResultDto.success(presentation, Message.SUCCESS);
    }
}
