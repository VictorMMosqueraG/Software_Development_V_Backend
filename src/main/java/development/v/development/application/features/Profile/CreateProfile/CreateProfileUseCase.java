package development.v.development.application.features.Profile.CreateProfile;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Profile.CreateProfile.Dtos.CreateProfileRequestDto;
import development.v.development.application.features.Profile.CreateProfile.Mappers.CreateProfileMapper;
import development.v.development.domain.exceptions.ConflictException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Profile;
import development.v.development.domain.repositories.ProfileRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateProfileUseCase {

    private final ProfileRepository profileRepository;

    public CreateProfileUseCase(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public DataResultDto<Profile> execute(CreateProfileRequestDto request) {

        if (profileRepository.existsByPerfDescripcion(request.getPerfDescripcion())) {
            throw new ConflictException(Message.ALREADY_EXIST + " Descripción del perfil");
        }

        Profile domain = CreateProfileMapper.toDomain(request);
        profileRepository.save(domain);

        return DataResultDto.success(domain, Message.SUCCESS);
    }
}
