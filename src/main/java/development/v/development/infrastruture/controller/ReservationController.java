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

import development.v.development.application.features.Reservation.CreateReservation.CreateReservationUseCase;
import development.v.development.application.features.Reservation.CreateReservation.Dtos.CreateReservationRequestDto;
import development.v.development.application.features.Reservation.DeleteReservation.DeleteReservationUseCase;
import development.v.development.application.features.Reservation.GetAllReservation.GetAllReservationUseCase;
import development.v.development.application.features.Reservation.GetAllReservation.Dtos.GetAllReservationQuery;
import development.v.development.application.features.Reservation.GetReservationById.GetReservationByIdUseCase;
import development.v.development.application.features.Reservation.UpdateReservation.UpdateReservationUseCase;
import development.v.development.application.features.Reservation.UpdateReservation.Dtos.UpdateReservationRequest;
import development.v.development.domain.models.Reservation;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Reservacion", description = "Administra las reservaciones")
@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    private final CreateReservationUseCase createUseCase;
    private final GetAllReservationUseCase getAllUseCase;
    private final GetReservationByIdUseCase getByIdUseCase;
    private final UpdateReservationUseCase updateUseCase;
    private final DeleteReservationUseCase deleteUseCase;

    public ReservationController(
        CreateReservationUseCase createUseCase,
        GetAllReservationUseCase getAllUseCase,
        GetReservationByIdUseCase getByIdUseCase,
        UpdateReservationUseCase updateUseCase,
        DeleteReservationUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea una nueva reservacion", description = "Permite crear una nueva reservacion con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<Reservation>> create(
            @Valid @RequestBody CreateReservationRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de reservaciones", description = "Permite obtener una lista de reservaciones con paginación y filtros opcionales")
    @GetMapping
    public ResponseEntity<PaginatedResultDto<List<Reservation>>> getAll(
            @ParameterObject
            @Valid
            @ModelAttribute GetAllReservationQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene una reservacion por su ID", description = "Permite obtener los detalles de una reservacion específica utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<Reservation>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza una reservacion existente", description = "Permite actualizar los datos de una reservacion existente utilizando su ID")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<Reservation>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateReservationRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina una reservacion por su ID", description = "Permite eliminar una reservacion específica utilizando su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<Reservation>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
