package development.v.development.infrastruture.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import development.v.development.application.features.Profile.CreateProfile.CreateProfileUseCase;
import development.v.development.application.features.Profile.CreateProfile.Dtos.CreateProfileRequestDto;
import development.v.development.application.features.Profile.DeleteProfile.DeleteProfileUseCase;
import development.v.development.application.features.Profile.GetAllProfile.GetAllProfileUseCase;
import development.v.development.application.features.Profile.GetAllProfile.Dtos.GetAllProfileQuery;
import development.v.development.application.features.Profile.GetProfileById.GetProfileByIdUseCase;
import development.v.development.application.features.Profile.UpdateProfile.UpdateProfileUseCase;
import development.v.development.application.features.Profile.UpdateProfile.Dtos.UpdateProfileRequest;
import development.v.development.domain.models.Profile;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Profile", description = "Administra los perfiles")
@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    private final CreateProfileUseCase createUseCase;
    private final GetAllProfileUseCase getAllUseCase;
    private final GetProfileByIdUseCase getByIdUseCase;
    private final UpdateProfileUseCase updateUseCase;
    private final DeleteProfileUseCase deleteUseCase;

    public ProfileController(
        CreateProfileUseCase createUseCase,
        GetAllProfileUseCase getAllUseCase,
        GetProfileByIdUseCase getByIdUseCase,
        UpdateProfileUseCase updateUseCase,
        DeleteProfileUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea un nuevo perfil", description = "Permite crear un nuevo perfil con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<Profile>> create(
            @Valid @RequestBody CreateProfileRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUseCase.execute(request));
    }

    @Operation(
        summary = "Obtiene una lista paginada de perfiles",
        description = "Permite obtener una lista de perfiles con paginación y filtros opcionales")
    @GetMapping()
    public ResponseEntity<PaginatedResultDto<List<Profile>>> getAll(
            @ParameterObject
            @Valid
            @ModelAttribute GetAllProfileQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene un perfil por su ID", description = "Permite obtener los detalles de un perfil específico utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<Profile>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza un perfil existente", description = "Permite actualizar los datos de un perfil existente utilizando su ID")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<Profile>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateProfileRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina un perfil por su ID", description = "Permite eliminar un perfil específico utilizando su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<Profile>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
