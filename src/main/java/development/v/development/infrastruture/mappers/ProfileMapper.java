package development.v.development.infrastruture.mappers;

import development.v.development.domain.models.Profile;
import development.v.development.infrastruture.entities.ProfileEntity;
import development.v.development.infrastruture.enums.ProfileStatus;

public class ProfileMapper {
    public static Profile toDomain(ProfileEntity entity) {
        Profile profile = new Profile();
        profile.setPerfId(entity.getPerfId());
        profile.setPerfDescripcion(entity.getPerfDescripcion());
        profile.setPerfEstado(entity.getPerfEstado() != null
                ? entity.getPerfEstado().name() : null);
        profile.setCreatedAt(entity.getCreatedAt());
        profile.setUpdatedAt(entity.getUpdatedAt());
        return profile;
    }

    public static ProfileEntity toEntity(Profile profile) {
        ProfileEntity entity = new ProfileEntity();
        entity.setPerfId(profile.getPerfId());
        entity.setPerfDescripcion(profile.getPerfDescripcion());
        if (profile.getPerfEstado() != null) {
            entity.setPerfEstado(ProfileStatus
                    .valueOf(profile.getPerfEstado()));
        }
        return entity;
    }
}
