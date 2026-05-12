package development.v.development.application.features.Profile.DeleteProfile;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Profile;
import development.v.development.domain.repositories.ProfileRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeleteProfileUseCase {

    private final ProfileRepository profileRepository;

    public DeleteProfileUseCase(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public DataResultDto<Profile> execute(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        profileRepository.delete(id);
        return DataResultDto.success(profile, Message.SUCCESS);
    }
}
