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

import development.v.development.application.features.Command.CreateCommand.CreateCommandUseCase;
import development.v.development.application.features.Command.CreateCommand.Dtos.CreateCommandRequestDto;
import development.v.development.application.features.Command.DeleteCommand.DeleteCommandUseCase;
import development.v.development.application.features.Command.GetAllCommand.GetAllCommandUseCase;
import development.v.development.application.features.Command.GetAllCommand.Dtos.GetAllCommandQuery;
import development.v.development.application.features.Command.GetCommandById.GetCommandByIdUseCase;
import development.v.development.application.features.Command.UpdateCommand.UpdateCommandUseCase;
import development.v.development.application.features.Command.UpdateCommand.Dtos.UpdateCommandRequestDto;
import development.v.development.domain.models.Command;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Command", description = "Administra las comandas")
@RestController
@RequestMapping("/api/v1/commands")
public class CommandController {

    private final CreateCommandUseCase createUseCase;
    private final GetAllCommandUseCase getAllUseCase;
    private final GetCommandByIdUseCase getByIdUseCase;
    private final UpdateCommandUseCase updateUseCase;
    private final DeleteCommandUseCase deleteUseCase;

    public CommandController(
            CreateCommandUseCase createUseCase,
            GetAllCommandUseCase getAllUseCase,
            GetCommandByIdUseCase getByIdUseCase,
            UpdateCommandUseCase updateUseCase,
            DeleteCommandUseCase deleteUseCase) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea una nueva comanda")
    @PostMapping
    public ResponseEntity<DataResultDto<Command>> create(
            @Valid @RequestBody CreateCommandRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de comandas")
    @GetMapping
    public ResponseEntity<PaginatedResultDto<List<Command>>> getAll(
            @ParameterObject @Valid @ModelAttribute GetAllCommandQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene una comanda por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<Command>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza una comanda existente")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<Command>> update(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateCommandRequestDto request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina una comanda por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<Command>> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
