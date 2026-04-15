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

import development.v.development.application.features.Order.CreateOrder.CreateOrderUseCase;
import development.v.development.application.features.Order.CreateOrder.Dtos.CreateOrderRequestDto;
import development.v.development.application.features.Order.DeleteOrder.DeleteOrderUseCase;
import development.v.development.application.features.Order.GetAllOrder.GetAllOrderUseCase;
import development.v.development.application.features.Order.GetAllOrder.Dtos.GetAllOrderQuery;
import development.v.development.application.features.Order.GetOrderById.GetOrderByIdUseCase;
import development.v.development.application.features.Order.UpdateOrder.UpdateOrderUseCase;
import development.v.development.application.features.Order.UpdateOrder.Dtos.UpdateOrderRequestDto;
import development.v.development.domain.models.Order;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Order", description = "Administra los pedidos")
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final CreateOrderUseCase createUseCase;
    private final GetAllOrderUseCase getAllUseCase;
    private final GetOrderByIdUseCase getByIdUseCase;
    private final UpdateOrderUseCase updateUseCase;
    private final DeleteOrderUseCase deleteUseCase;

    public OrderController(
            CreateOrderUseCase createUseCase,
            GetAllOrderUseCase getAllUseCase,
            GetOrderByIdUseCase getByIdUseCase,
            UpdateOrderUseCase updateUseCase,
            DeleteOrderUseCase deleteUseCase) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @Operation(summary = "Crea un nuevo pedido", description = "Permite crear un nuevo pedido con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<Order>> create(
            @Valid @RequestBody CreateOrderRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUseCase.execute(request));
    }

    @Operation(summary = "Obtiene una lista paginada de pedidos", description = "Permite obtener una lista de pedidos con paginacion y filtros opcionales")
    @GetMapping
    public ResponseEntity<PaginatedResultDto<List<Order>>> getAll(
            @ParameterObject
            @Valid
            @ModelAttribute GetAllOrderQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

    @Operation(summary = "Obtiene un pedido por su ID", description = "Permite obtener los detalles de un pedido especifico utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<Order>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }

    @Operation(summary = "Actualiza un pedido existente", description = "Permite actualizar los datos de un pedido existente utilizando su ID")
    @PutMapping("/{id}")
    public ResponseEntity<DataResultDto<Order>> update(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateOrderRequestDto request) {
        return ResponseEntity.ok(updateUseCase.execute(id, request));
    }

    @Operation(summary = "Elimina un pedido por su ID", description = "Permite eliminar un pedido especifico utilizando su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<DataResultDto<Order>> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(deleteUseCase.execute(id));
    }
}

