package development.v.development.application.features.Profile.UpdateProfile.Mappers;

import development.v.development.application.features.Profile.UpdateProfile.Dtos.UpdateProfileRequest;
import development.v.development.domain.models.Profile;

public class UpdateProfileMapper {

    public static Profile toDomain(Long id, UpdateProfileRequest request) {
        Profile profile = new Profile();
        profile.setPerfId(id);
        profile.setPerfDescripcion(request.getPerfDescripcion());
        profile.setPerfEstado(request.getPerfEstado());
        return profile;
    }
}
