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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import development.v.development.application.features.User.CreateUser.CreateUserUseCase;
import development.v.development.application.features.User.CreateUser.Dtos.CreateUserRequestDto;
import development.v.development.application.features.User.DeleteUser.DeleteUserUseCase;
import development.v.development.application.features.User.GetAllUser.GetAllUserUseCase;
import development.v.development.application.features.User.GetAllUser.Dtos.GetAllUserQuery;
import development.v.development.application.features.User.GetUserById.GetUserByIdUseCase;
import development.v.development.application.features.User.UpdateUser.UpdateUserUseCase;
import development.v.development.application.features.User.UpdateUser.Dtos.UpdateUserRequest;
import development.v.development.domain.models.User;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "User", description = "Administra los usuarios")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final CreateUserUseCase createUseCase;
    private final GetAllUserUseCase getAllUseCase;
    private final GetUserByIdUseCase getByIdUseCase;
    private final UpdateUserUseCase updateUseCase;
    private final DeleteUserUseCase deleteUseCase;

    public UserController(
        CreateUserUseCase createUseCase,
        GetAllUserUseCase getAllUseCase,
        GetUserByIdUseCase getByIdUseCase,
        UpdateUserUseCase updateUseCase,
        DeleteUserUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea un nuevo usuario", description = "Permite crear un nuevo usuario con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<User>> create(
            @Valid @RequestBody CreateUserRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUseCase.execute(request));
    }

    @Operation(
        summary = "Obtiene una lista paginada de usuarios",
        description = "Permite obtener una lista de usuarios con paginación y filtros opcionales")
    @GetMapping()
    public ResponseEntity<PaginatedResultDto<List<User>>> getAll(
            @ParameterObject
            @Valid
            @ModelAttribute GetAllUserQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene un usuario por su ID", description = "Permite obtener los detalles de un usuario específico utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<User>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza un usuario existente", description = "Permite actualizar los datos de un usuario existente utilizando su ID")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<User>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateUserRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina un usuario por su ID", description = "Permite eliminar un usuario específico utilizando su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<User>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
