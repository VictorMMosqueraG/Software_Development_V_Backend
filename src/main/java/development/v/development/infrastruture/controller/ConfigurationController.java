package development.v.development.infrastruture.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import development.v.development.application.features.Configuration.CreateConfiguration.CreateConfigurationUseCase;
import development.v.development.application.features.Configuration.CreateConfiguration.Dtos.CreateConfigurationRequestDto;
import development.v.development.application.features.Configuration.DeleteConfiguration.DeleteConfigurationUseCase;
import development.v.development.application.features.Configuration.GetAllConfiguration.GetAllConfigurationUseCase;
import development.v.development.application.features.Configuration.GetAllConfiguration.Dtos.GetAllConfigurationQuery;
import development.v.development.application.features.Configuration.GetConfigurationById.GetConfigurationByIdUseCase;
import development.v.development.application.features.Configuration.UpdateConfiguration.UpdateConfigurationUseCase;
import development.v.development.application.features.Configuration.UpdateConfiguration.Dtos.UpdateConfigurationRequest;
import development.v.development.domain.models.Configuration;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Configuration", description = "Administra las configuraciones")
@RestController
@RequestMapping("/api/v1/configurations")
public class ConfigurationController {

    private final CreateConfigurationUseCase createUseCase;
    private final GetAllConfigurationUseCase getAllUseCase;
    private final GetConfigurationByIdUseCase getByIdUseCase;
    private final UpdateConfigurationUseCase updateUseCase;
    private final DeleteConfigurationUseCase deleteUseCase;

    public ConfigurationController(
        CreateConfigurationUseCase createUseCase,
        GetAllConfigurationUseCase getAllUseCase,
        GetConfigurationByIdUseCase getByIdUseCase,
        UpdateConfigurationUseCase updateUseCase,
        DeleteConfigurationUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea una nueva configuracion")
    @PostMapping
    public ResponseEntity<DataResultDto<Configuration>> create(
            @Valid @RequestBody CreateConfigurationRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de configuraciones")
    @GetMapping
    public ResponseEntity<PaginatedResultDto<List<Configuration>>> getAll(
            @ParameterObject @Valid @ModelAttribute GetAllConfigurationQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene una configuracion por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<Configuration>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza una configuracion existente")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<Configuration>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateConfigurationRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina una configuracion por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<Configuration>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
