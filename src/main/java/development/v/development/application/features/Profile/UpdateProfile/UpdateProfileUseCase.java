package development.v.development.application.features.Profile.UpdateProfile;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Profile.UpdateProfile.Dtos.UpdateProfileRequest;
import development.v.development.application.features.Profile.UpdateProfile.Mappers.UpdateProfileMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Profile;
import development.v.development.domain.repositories.ProfileRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdateProfileUseCase {
    private final ProfileRepository profileRepository;

    public UpdateProfileUseCase(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public DataResultDto<Profile> execute(Long id, UpdateProfileRequest request) {

        profileRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        Profile domain = UpdateProfileMapper.toDomain(id, request);
        Profile updatedProfile = profileRepository.update(domain);

        return DataResultDto.success(
                updatedProfile,
                Message.SUCCESS);
    }
}
