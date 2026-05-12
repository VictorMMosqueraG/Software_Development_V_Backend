package development.v.development.application.features.Presentation.GetAllPresentation;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Presentation.GetAllPresentation.Dtos.GetAllPresentationQuery;
import development.v.development.application.features.Presentation.GetAllPresentation.Mappers.GetAllPresentationMapper;
import development.v.development.domain.models.Presentation;
import development.v.development.domain.repositories.PresentationRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllPresentationUseCase {

    private final PresentationRepository repository;

    public GetAllPresentationUseCase(PresentationRepository presentationRepository) {
        this.repository = presentationRepository;
    }

    public PaginatedResultDto<List<Presentation>> execute(GetAllPresentationQuery query) {
        return repository.findAllPaginated(GetAllPresentationMapper.toFilter(query));
    }
}
