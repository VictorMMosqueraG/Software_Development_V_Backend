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

import development.v.development.application.features.OrderDetail.CreateOrderDetail.CreateOrderDetailUseCase;
import development.v.development.application.features.OrderDetail.CreateOrderDetail.Dtos.CreateOrderDetailRequestDto;
import development.v.development.application.features.OrderDetail.DeleteOrderDetail.DeleteOrderDetailUseCase;
import development.v.development.application.features.OrderDetail.GetAllOrderDetail.GetAllOrderDetailUseCase;
import development.v.development.application.features.OrderDetail.GetAllOrderDetail.Dtos.GetAllOrderDetailQuery;
import development.v.development.application.features.OrderDetail.GetOrderDetailById.GetOrderDetailByIdUseCase;
import development.v.development.application.features.OrderDetail.UpdateOrderDetail.UpdateOrderDetailUseCase;
import development.v.development.application.features.OrderDetail.UpdateOrderDetail.Dtos.UpdateOrderDetailRequest;
import development.v.development.domain.models.OrderDetail;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Pedido Detalle", description = "Administra los detalles de pedidos")
@RestController
@RequestMapping("/api/v1/order-details")
public class OrderDetailController {

    private final CreateOrderDetailUseCase createUseCase;
    private final GetAllOrderDetailUseCase getAllUseCase;
    private final GetOrderDetailByIdUseCase getByIdUseCase;
    private final UpdateOrderDetailUseCase updateUseCase;
    private final DeleteOrderDetailUseCase deleteUseCase;

    public OrderDetailController(
        CreateOrderDetailUseCase createUseCase,
        GetAllOrderDetailUseCase getAllUseCase,
        GetOrderDetailByIdUseCase getByIdUseCase,
        UpdateOrderDetailUseCase updateUseCase,
        DeleteOrderDetailUseCase deleteUseCase
    ) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea un nuevo detalle de pedido", description = "Permite crear un nuevo detalle de pedido con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<OrderDetail>> create(
            @Valid @RequestBody CreateOrderDetailRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de detalles de pedido", description = "Permite obtener una lista de detalles de pedido con paginación y filtros opcionales")
    @GetMapping
    public ResponseEntity<PaginatedResultDto<List<OrderDetail>>> getAll(
            @ParameterObject
            @Valid
            @ModelAttribute GetAllOrderDetailQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene un detalle de pedido por su ID", description = "Permite obtener los detalles de un detalle de pedido específico utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<OrderDetail>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza un detalle de pedido existente", description = "Permite actualizar los datos de un detalle de pedido existente utilizando su ID")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<OrderDetail>> update(
            @PathVariable Long id,
            @Valid @RequestBody UpdateOrderDetailRequest request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina un detalle de pedido por su ID", description = "Permite eliminar un detalle de pedido específico utilizando su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<OrderDetail>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}
