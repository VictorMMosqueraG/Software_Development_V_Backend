package development.v.development.application.features.Profile.CreateProfile.Mappers;

import development.v.development.application.features.Profile.CreateProfile.Dtos.CreateProfileRequestDto;
import development.v.development.domain.models.Profile;

public class CreateProfileMapper {

    public static Profile toDomain(CreateProfileRequestDto request) {
        Profile profile = new Profile();
        profile.setPerfDescripcion(request.getPerfDescripcion());
        profile.setPerfEstado(request.getPerfEstado());
        return profile;
    }
}
