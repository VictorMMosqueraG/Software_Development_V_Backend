package development.v.development.application.features.Presentation.UpdatePresentation;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Presentation.UpdatePresentation.Dtos.UpdatePresentationRequest;
import development.v.development.application.features.Presentation.UpdatePresentation.Mappers.UpdatePresentationMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Presentation;
import development.v.development.domain.repositories.PresentationRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdatePresentationUseCase {
    private final PresentationRepository presentationRepository;

    public UpdatePresentationUseCase(PresentationRepository presentationRepository) {
        this.presentationRepository = presentationRepository;
    }

    public DataResultDto<Presentation> execute(Long id, UpdatePresentationRequest request) {
        presentationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        Presentation domain = UpdatePresentationMapper.toDomain(id, request);
        Presentation updated = presentationRepository.update(domain);

        return DataResultDto.success(updated, Message.SUCCESS);
    }
}
