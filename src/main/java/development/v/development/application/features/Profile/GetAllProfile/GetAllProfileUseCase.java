package development.v.development.application.features.Profile.GetAllProfile;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Profile.GetAllProfile.Dtos.GetAllProfileQuery;
import development.v.development.application.features.Profile.GetAllProfile.Mappers.GetAllProfileMapper;
import development.v.development.domain.models.Profile;
import development.v.development.domain.repositories.ProfileRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllProfileUseCase {

    private final ProfileRepository repository;

    public GetAllProfileUseCase(ProfileRepository profileRepository) {
        this.repository = profileRepository;
    }

    public PaginatedResultDto<List<Profile>> execute(GetAllProfileQuery query) {
        return repository.findAllPaginated(GetAllProfileMapper.toFilter(query));
    }
}
