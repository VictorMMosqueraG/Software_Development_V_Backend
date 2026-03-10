package development.v.development.infrastruture.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import development.v.development.application.features.Customer.CreateCustomer.CreateCustomerUseCase;
import development.v.development.application.features.Customer.CreateCustomer.Dtos.CreateCustomerRequestDto;
import development.v.development.application.features.Customer.GetAllCustomer.GetAllCustomerUseCase;
import development.v.development.application.features.Customer.GetAllCustomer.Dtos.GetAllCustomerQuery;
import development.v.development.application.features.Customer.GetCustomerById.GetCustomerByIdUseCase;
import development.v.development.domain.models.Customer;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.domain.responses.PaginatedResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Customer", description = "Administra los clientes")
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CreateCustomerUseCase createUseCase;
    private final GetAllCustomerUseCase getAllUseCase;
    private final GetCustomerByIdUseCase getByIdUseCase;

    public CustomerController(CreateCustomerUseCase createUseCase, GetAllCustomerUseCase getAllUseCase, GetCustomerByIdUseCase getByIdUseCase) {
        this.createUseCase = createUseCase;
        this.getAllUseCase = getAllUseCase;
        this.getByIdUseCase = getByIdUseCase;
    }

    @Operation(summary = "Crea un nuevo cliente", description = "Permite crear un nuevo cliente con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<Customer>> create(
            @Valid @RequestBody CreateCustomerRequestDto request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createUseCase.execute(request));
    }

    @Operation(
        summary = " Obtiene una lista paginada de clientes", 
        description = "Permite obtener una lista de clientes con paginación y filtros opcionales")
    @GetMapping()
    public ResponseEntity<PaginatedResultDto<List<Customer>>> getAll(
            @ParameterObject 
            @Valid 
            @ModelAttribute GetAllCustomerQuery query) {
        return ResponseEntity.ok(getAllUseCase.execute(query));
    }

     @Operation(summary = "Obtiene un cliente por su ID", description = "Permite obtener los detalles de un cliente específico utilizando su ID")
    @GetMapping("/{id}")
    public ResponseEntity<DataResultDto<Customer>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(getByIdUseCase.execute(id));
    }
}
